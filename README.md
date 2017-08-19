# jersey-rest-hateoas
A simple Jersey REST Service explaining about how to create HATEOAS service

A hypermedia-driven site provides information to navigate the site's REST interfaces dynamically by including hypermedia links with the responses

1. Create Class(HateoasVO) for link and rel attributes

2. Declare the HateoasVO class as List<HateoasVO>

3. add a custom method in the Parent Class to add the links (addLink()) and store them in the list

4. build the Uri using the @Context UriInfo

String link = uriInfo.getBaseUriBuilder().path(StudentService.class).path(String.valueOf(id)).build()
				.toString();

5. add the link and the rel attribute to the Parent Object by calling the addLink() method

6. return the Object

