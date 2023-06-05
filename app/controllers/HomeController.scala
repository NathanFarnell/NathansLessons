package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import services.ApiService

import scala.concurrent.ExecutionContext

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */

@Singleton
class HomeController @Inject()(
                                val controllerComponents: ControllerComponents,
                                val apiService: ApiService
                              )(implicit ec: ExecutionContext) extends BaseController {

  def index(): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    apiService.makeApiCall().flatMap { pokemonModel => {
      val pokemonNames = pokemonModel.results.map(_.name)

      apiService.getPokemonImages(pokemonNames).map { allData =>
        Ok(views.html.index(allData))
      }
    }
    }
  }
}
