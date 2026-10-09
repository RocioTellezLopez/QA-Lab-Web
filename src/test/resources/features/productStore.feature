Feature: Product - Store

  @test-store
  Scenario Outline: Validación del precio de un producto

    Given estoy en la página de la tienda
    And me logueo con mi usuario "<mail>" y clave "<password>"
    When navego a la categoria "<category>" y subcategoria "<subcategory>"
    And agrego 2 unidades del primer producto al carrito
    Then valido en el popup la confirmación del producto agregado
    And valido en el popup que el monto total sea calculado correctamente
    When finalizo la compra
    Then valido el titulo de la pagina del carrito
    And vuelvo a validar el calculo de precios en el carrito

    Examples:
    | mail                      | password       | category  |  subcategory |
    | dikew43375@leafflip.com   | pass@valid123  | Clothes   |  Men         |
    | vasece7241@comzx.com      | invalid@123    | Clothes   |  Men         |
    | hopereb266@leafflip.com   | pass@valid789  | Cart      |  Men         |