package tibo.jee.exorestvoiture.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import tibo.jee.exorestvoiture.entity.Car;
import tibo.jee.exorestvoiture.service.CarService;

import java.util.List;

@Path("/car")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarResource {
    private final CarService service;

    @Inject
    public CarResource(CarService service) {
        this.service = service;
    }

    @GET
    @Path("/{id}")
    public Car get(@PathParam("id") int id) {
        return service.get(id);
    }

    @GET
    public List<Car> getAll() {
        return service.getAll();
    }

    @POST
    public Car create(@QueryParam("brand") String brand, @QueryParam("year") int year, @QueryParam("color") String color) {
        return service.create(brand, year, color);
    }

    @PUT
    @Path("/{id}")
    public Car updatePut(@PathParam("id") int id, @QueryParam("brand") String brand, @QueryParam("year") int year, @QueryParam("color") String color) {
        return service.update(id, brand, year, color);
    }

    @PATCH
    @Path("/{id}")
    public Car updatePatch(@PathParam("id") int id, @QueryParam("brand") String brand, @QueryParam("year") String year, @QueryParam("color") String color) {
        if (brand != null) service.updateBrand(id, brand);
        try {
            if (year != null) service.updateYear(id, Integer.parseInt(year));
        } catch (NumberFormatException ignored) {
        }
        if (color != null) service.updateColor(id, color);
        return service.get(id);
    }

    /*@PATCH
    @Path("/{id}/brand")
    public Car updateBrand(@PathParam("id") int id, @QueryParam("brand") String brand) {
        return service.updateBrand(id, brand);
    }

    @PATCH
    @Path("/{id}/year")
    public Car updateYear(@PathParam("id") int id, @QueryParam("year") int year) {
        return service.updateYear(id, year);
    }

    @PATCH
    @Path("/{id}/color")
    public Car updateColor(@PathParam("id") int id, @QueryParam("color") String color) {
        return service.updateColor(id, color);
    }*/

    @DELETE
    @Path("/{id}")
    public Car delete(@PathParam("id") int id) {
        return service.delete(id);
    }
}