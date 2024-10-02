package com.everis.base.stepDefinitions;

import com.everis.base.models.Order;
import com.everis.base.steps.PetStoreCreateOrderStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PetStoreCreateOrderSD {

    @Steps
    PetStoreCreateOrderStep petStoreCreateOrderStep;

    @Given("que estoy en la pagina principal")
    public void queEstoyEnLaPaginaPrincipal() {
    }

    @When("creo una orden con id{int}, petId{int}, quantity{int}")
    public void creoUnaOrdenConIdIdPetIdPetIdQuantityQuantity(int id, int petId, int quantity) {
        petStoreCreateOrderStep.crearOrden(id, petId, quantity);
    }

    @Then("el código de estado de la respuesta debe ser {int}")
    public void elCódigoDeEstadoDeLaRespuestaDebeSerCode(int code) {
        petStoreCreateOrderStep.validarCodigoRespuesta(code);
    }

    @And("la respuesta debe contener el id{int}")
    public void laRespuestaDebeContenerElIdId(int id) {
        Order order = petStoreCreateOrderStep.obtenerRespuestadeOrder();
        assertNotNull(order);
        assertEquals(id,order.getId());
    }

}
