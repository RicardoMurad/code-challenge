package com.vivareal.controller.endpoint

import br.com.six2six.fixturefactory.Fixture
import com.vivareal.controller.assembler.PropertyResourceAssembler
import com.vivareal.model.Property
import com.vivareal.service.PropertyService
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates
import static org.mockito.Matchers.any
import static org.mockito.Matchers.anyLong
import static org.mockito.Mockito.doReturn
import static org.mockito.Mockito.when
import static org.mockito.MockitoAnnotations.initMocks
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup

class PropertyControllerTest extends Specification {

    @InjectMocks
    PropertyController controller

    @Mock
    PropertyService service;

    @Mock
    PropertyResourceAssembler assembler;

    MockMvc mockMvc

    def "should save property and return json response"() {

        given: "a user want to save the following json"

            def json =
                    """
                        {
                          "x": 222,
                          "y": 444,
                          "title": "Imóvel código 1, com 5 quartos e 4 banheiros",
                          "price": 1250000,
                          "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                          "beds": 4,
                          "baths": 3,
                          "squareMeters": 210
                        }
                    """

        doReturn(Fixture.from(Property.class)
                .gimme("valid"))
                .when(service).save(any(Property.class))

        when(assembler.toResource(any())).thenCallRealMethod();

        when: "user perform request"

         def result = this.mockMvc.perform(
                    get("/properties")
                            .content(json)
                            .accept(MediaType.APPLICATION_JSON))

        then: "Should retur status CREATED with id"
            result
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath('$.id').exists())
                    .andExpect(jsonPath('$.title').exists())
                    .andExpect(jsonPath('$.price').exists())
                    .andExpect(jsonPath('$.description').exists())
                    .andExpect(jsonPath('$.x').exists())
                    .andExpect(jsonPath('$.y').exists())
                    .andExpect(jsonPath('$.beds').exists())
                    .andExpect(jsonPath('$.baths').exists())
                    .andExpect(jsonPath('$.provinces').exists())
                    .andExpect(jsonPath('$.squareMeters').exists())

    }

    def "should return Bad Request when dos not have all parameters"() {

        given: "a user want to save the following json"

        def json =
                """
                        {
                          "title": "Imóvel código 1, com 5 quartos e 4 banheiros"
                        }
                    """

        doReturn(Fixture.from(Property.class).gimme("valid"))
                .when(service).save(any(Property.class))

        when(assembler.toResource(any())).thenCallRealMethod();

        when: "user perform request"

        def result = this.mockMvc.perform(
                post("/properties")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))

        then: "Should retur status BAD REQUEST"
            result
                .andExpect(status().isBadRequest())
    }

    def "should return by id and status Found when item found"() {

        doReturn(Optional.of(Fixture.from(Property.class).gimme("valid")))
                .when(service).findById(anyLong())

        when(assembler.toResource(any())).thenCallRealMethod();

        given: "user have a id 1L"
            def id = 1L

        when: "user perform request"

            def result = this.mockMvc.perform(
                    get("/properties/${id}")
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))

        then: "Should return json response with FOUND status"
            result
                .andExpect(status().isFound())
                .andExpect(jsonPath('$.id').exists())
                .andExpect(jsonPath('$.title').exists())
                .andExpect(jsonPath('$.price').exists())
                .andExpect(jsonPath('$.description').exists())
                .andExpect(jsonPath('$.x').exists())
                .andExpect(jsonPath('$.y').exists())
                .andExpect(jsonPath('$.beds').exists())
                .andExpect(jsonPath('$.baths').exists())
                .andExpect(jsonPath('$.provinces').exists())
                .andExpect(jsonPath('$.squareMeters').exists())
    }

    def "should return Not Found item does not exists"() {

        doReturn(Optional.empty())
                .when(service).findById(anyLong())

        when(assembler.toResource(any())).thenCallRealMethod();

        given: "user have a id 1L"
        def id = 1L

        when: "user perform request"

        def result = this.mockMvc.perform(
                get("/properties/${id}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))

        then: "Should return json response with FOUND status"
        result
                .andExpect(status().isNotFound())

    }

    void setup() {
        loadTemplates("com.vivareal.model.templates");
        initMocks(this)
        mockMvc = standaloneSetup(controller).build()
    }

}
