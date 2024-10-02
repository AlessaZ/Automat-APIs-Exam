package com.everis.base.steps;

import com.everis.base.models.Order;

import static net.serenitybdd.rest.RestRequests.given;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PetStoreGetOrderStep {

    private String URL_BASE="https://petstore.swagger.io/v2";
    public Order order;

    public void consultarOrder(int id) {
        order = given()
                .baseUri(URL_BASE)
                .log()
                .all()
                .when()
                .get("/store/order/"+id)
                .as(Order.class);
        listarOrder(order);
    }
    private void listarOrder(Order order) {
        System.out.println("*************************************************************");
        System.out.println("OUT: ID "+ order.getId());
        System.out.println("OUT: PetID "+ order.getPetId());
        System.out.println("OUT: Quantity "+ order.getQuantity());
        System.out.println("OUT: shipDate " + order.getShipDate());
        System.out.println("OUT: Status " + order.getStatus());
        System.out.println("OUT: Complete " + order.isComplete());
        System.out.println("*************************************************************");
    }

    public void validarCodigoRespuesta(int code) {
        assertThat(lastResponse().statusCode(),is(code));
    }

    public Order obtenerRespuestadeOrder(){
        return order;
    }

}
