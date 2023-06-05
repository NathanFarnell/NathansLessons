package services

import models.{IndividualPokemon, PokemonModel}
import play.api.libs.ws.{WSClient, WSRequest}

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}
import models.PokemonModel

class ApiService @Inject()(ws: WSClient)(implicit ec: ExecutionContext) {

  def makeApiCall(): Future[PokemonModel] = {
    val url = "https://pokeapi.co/api/v2/pokemon?limit=151&offset=0"

    val request = ws.url(url)

    val headers: Map[String, String] = Map("Authorization" -> "TestToken")

    val requestWithHeaders: WSRequest = request.withHttpHeaders(headers.toSeq: _*)

    requestWithHeaders.get().map(response => response.json.as[PokemonModel])
  }

  def getPokemonImages(pokemonNames: Seq[String]): Future[Seq[IndividualPokemon]] = {
    val url = "https://pokeapi.co/api/v2/pokemon"

    val requestFutures: Seq[Future[IndividualPokemon]] = pokemonNames.map { name =>
      val request = ws.url(s"$url/$name").addHttpHeaders("Authorization"-> "BearerToken")

      request.get().map(response => response.json.as[IndividualPokemon])
    }

    Future.sequence(requestFutures)
  }
}
