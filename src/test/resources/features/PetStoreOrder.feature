Feature: Gestión de órdenes de tienda de mascotas

  @CrearOrden
  Scenario Outline: Crear una nueva orden
    Given que estoy en la pagina principal
    When creo una orden con id<id>, petId<petId>, quantity<quantity>
    Then el código de estado de la respuesta debe ser <code>
    And la respuesta debe contener el id<id>
    Examples:
      | id   | petId    | quantity | code | |
      | 205  | 2        | 3        | 200  | |
      | 206  | 2        | 3        | 200  | |
      | 207  | 3        | 1        | 200  | |
      | 208  | 3        | 1        | 200  | |


  @ConsultarOrden
  Scenario Outline: Consultar una orden
    Given que estoy en la pagina
    When obtiene la orden con ID <id>
    Then verificar que el código de estado de la respuesta sea <code>
    And la respuesta debe contener el id<id>, petId<petId>,quantity<quantity>
    Examples:
      | id   | petId    | quantity | code | |
      | 205  | 2        | 3        | 200  | |
      | 206  | 2        | 3        | 200  | |
      | 207  | 3        | 1        | 200  | |
      | 208  | 3        | 1        | 200  | |
