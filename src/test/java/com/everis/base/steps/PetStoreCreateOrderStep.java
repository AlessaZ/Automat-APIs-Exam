package com.everis.base.steps;

import com.everis.base.models.Order;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PetStoreCreateOrderStep {

    private static final String URL_BASE = "https://petstore.swagger.io/v2";
    private Response response;
    private Order orderResponse;

    public void crearOrden(int id, int petId, int quantity) {
        Order order = new Order(id, petId, quantity);

        response = given()
                .baseUri(URL_BASE)
                .header("Content-Type", "application/json")
                .body(order)
                .when()
                .post("/store/order");

        orderResponse = response.as(Order.class);

        System.out.println("Creado: ID " + orderResponse.getId());
        System.out.println("Creado: Pet ID " + orderResponse.getPetId());
        System.out.println("Creado: Quantity " + orderResponse.getQuantity());
    }

    public void validarCodigoRespuesta(int code) {
        assertThat(response.getStatusCode(), is(code));
    }

    public Order obtenerRespuestadeOrder() {
        return orderResponse;
    }
}
