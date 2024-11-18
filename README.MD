# Example for a Hexagonal Project

This Repo serves as an example for a hexagonal Web-Server build with gradle.

The used framework is SpringBoot.

## Package Structure

```
/modules - Submodes
  L core - Domain Logic
  L persistence-adapter - JDBC-Database
  L ui - React app
  L web-api - Jackson-Endpoints
/src - glue to put all modules in a Service
```

The main goal is to decouple the core module's dependencies, making it agnostic to specific adapter
implementations. The core module should not rely on any Hibernate or Jackson-specific components.
These details are handled by the designated adapter modules.

This approach allows for changing the framework of a module without modifying the core logic. The
core defines adapter interfaces to specify how it expects to communicate with an adapter. The
adapter is then responsible for implementing the required behavior. For example, the core might have
a BookAdapter interface, while the persistence module would implement it as BookAdapterImpl.

Regarding the Jackson implementation: all public service methods can be used by the endpoints, but
the core itself is unaware of any specific request or response classes.

The UI module is a simple React application that displays the first page of persisted data.

Feel free to expand on this project as needed.

## how to run

You can either build the jar with ```./graldew build ``` or start the ```BookExplorerApplication```
from your favorite IDE.

The application is served on port 8080. During the build the UI is transpiled and moved inside the
embedded Tomcat.

The File ```insomnium-requests.yml``` provides some basic requests. You can import them to your
Insomnium application.

## no tests?

This Project serves as a showcase. It's based on one of my private projects, I just ripped
everything out to keep it simple. Maybe I add some tests at a later point.

## License

MIT License