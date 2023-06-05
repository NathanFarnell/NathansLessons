package models

import play.api.libs.json.{JsValue, Json, OFormat}

case class IndividualPokemon(
                              abilities: Seq[JsValue],
                              base_experience: Int,
                              forms: Seq[JsValue],
                              game_indices: Seq[JsValue],
                              height: Int,
                              held_items: Seq[JsValue],
                              id: Int,
                              is_default: Boolean,
                              location_area_encounters: String,
                              moves: Seq[JsValue],
                              name: String,
                              order: Int,
                              past_types: Seq[JsValue],
                              species: SpeciesData,
                              sprites: SpritesData,
                              stats: Seq[JsValue],
                              types: Seq[PokemonType],
                              weight: Int
                            )

case class SpeciesData(
                        name: String,
                        url: String
                      )

case class SpritesData(
                        back_default: String,
                        back_female: Option[String],
                        back_shiny: String,
                        back_shiny_female: Option[String],
                        front_default: String,
                        front_female: Option[String],
                        front_shiny: String,
                        front_shiny_female: Option[String],
                        other: OtherSpritesData
                      )

case class OtherSpritesData(
                             dream_world: DreamWorldSpritesData,
                             home: HomeSpritesData,
                             `official-artwork`: OfficialArtworkSpritesData
                           )

case class DreamWorldSpritesData(
                                  front_default: String,
                                  front_female: Option[String]
                                )

case class HomeSpritesData(
                            front_default: String,
                            front_female: Option[String],
                            front_shiny: String,
                            front_shiny_female: Option[String]
                          )

case class OfficialArtworkSpritesData(
                                       front_default: String,
                                       front_shiny: String
                                     )

case class PokemonType(
                        slot: Int,
                        `type`: TypeData
                      )

case class TypeData(
                     name: String,
                     url: String
                   )

object IndividualPokemon {
  implicit val speciesDataFormat: OFormat[SpeciesData] = Json.format[SpeciesData]
  implicit val dreamWorldSpritesDataFormat: OFormat[DreamWorldSpritesData] = Json.format[DreamWorldSpritesData]
  implicit val homeSpritesDataFormat: OFormat[HomeSpritesData] = Json.format[HomeSpritesData]
  implicit val officialArtworkSpritesDataFormat: OFormat[OfficialArtworkSpritesData] = Json.format[OfficialArtworkSpritesData]
  implicit val otherSpritesDataFormat: OFormat[OtherSpritesData] = Json.format[OtherSpritesData]
  implicit val spritesDataFormat: OFormat[SpritesData] = Json.format[SpritesData]
  implicit val typeFormat: OFormat[TypeData] = Json.format[TypeData]
  implicit val pokemonFormat: OFormat[PokemonType] = Json.format[PokemonType]
  implicit val format: OFormat[IndividualPokemon] = Json.format[IndividualPokemon]
}
