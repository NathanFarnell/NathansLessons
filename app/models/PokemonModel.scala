package models

import play.api.libs.json.{Json, OFormat}

case class PokemonData(name: String, url: String) {}

case class PokemonModel(count: Int, results: Seq[PokemonData])

object PokemonData {
  implicit val format: OFormat[PokemonData] = Json.format[PokemonData]
}

object PokemonModel {
  implicit val format: OFormat[PokemonModel] = Json.format[PokemonModel]
}
