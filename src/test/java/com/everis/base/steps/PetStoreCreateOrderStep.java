package com.everis.base.steps;

import com.everis.base.models.Order;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;

public class PetStoreCreateOrderStep {

    private String URL_BASE = "https://petstore.swagger.io/v2" ;
    private Response response;
    private int codigoRespuesta;
    private Order orderResponse;

    public void crearOrden(int id, int petId, int quantity) {
        Order order = new Order(id, petId, quantity);

        response = given()
                .baseUri(URL_BASE)
                .header("Content-Type", "application/json")
                .body(order)
                .when()
                .post("/store/order")
                .then()
                .statusCode(200)
                .extract()
                .response();

        codigoRespuesta = response.getStatusCode();
        orderResponse = response.as(Order.class);

        System.out.println("Creado: ID "+ orderResponse.getId());
        System.out.println("Creado: Pet ID "+ orderResponse.getPetId());
        System.out.println("Creado: Quantity "+ orderResponse.getQuantity());


    }

    public void validarCodigoRespuesta(int code) {
        if(code != codigoRespuesta){
            throw new AssertionError("Código esperado: "  + code + "Código obtenido: " + codigoRespuesta);
        }

    }

    public Order obtenerRespuestadeOrder(){
        return orderResponse;
    }

}
