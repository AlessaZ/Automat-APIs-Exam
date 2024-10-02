package com.everis.base.steps;

import com.everis.base.models.Order;
import static io.restassured.RestAssured.given;

public class PetStoreOrderStep {

    private String URL_BASE = "https://petstore.swagger.io/v2" ;
    public int codigoRespuesta;
    private Order orderResponse;

    public void crearOrden(int id, int petId, int quantity){
        Order order = new Order(id, petId, quantity);

        codigoRespuesta = given()
                .baseUri(URL_BASE)
                .header("Content-Type", "application/json")
                .body(order)
                .when()
                .post("/store/order")
                .then()
                .statusCode(200)
                .extract()
                .statusCode();

        orderResponse = given()
                .baseUri(URL_BASE)
                .when()
                .get("/store/order/"+id)
                .as(Order.class);

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
