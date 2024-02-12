---
unit: UD09
title: JavaFX en Visual Studio Code
language: ES
author: Arturo Blasco Cervera
subject: Programación
keywords: [PRG, 2024, Programacion, Java]
IES: IES Mestre Ramón Esteve (Catadau) [iesmre.es]
header: ${title} - ${subject} (ver. ${today}) 
footer:${currentFileName}.pdf - ${author} - ${IES} - ${pageNo}/${pageCount}
typora-root-url:${filename}/../
typora-copy-images-to:${filename}/../assets
---
[toc]

# Introducción

Vamos a ver cómo crear una aplicación `JavaFX` en Visual Studio Code. Necesitamos:

- Visual Studio Code.
- OpenJDK 17 (seguramente funcionará con una posterior).

# Proyectos JavaFX con el Visual Studio Code

Sigue estos pasos para crear un proyecto `JavaFX` utilizando las herramientas IDE para compilarlo y ejecutarlo ([enlace en la web oficial Visual Studio Code](https://code.visualstudio.com/docs/java/java-gui)).

## Crea un proyecto de Java

Puedes crear una nueva aplicación JavaFX con solo unos pocos pasos en VS Code:

- paso 1: instala el [paquete de extensión para Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack) (*Extension Pack for Java*, que ya debemos tenerlo instalado).
- paso 2: en Visual Studio Code, abre la paleta de comandos ( *Ctrl* + *Shift* + *P* ) y luego selecciona el comando **Java: Create Java Project...** .
- paso 3: selecciona la opción **JavaFX** en la lista, sigue el asistente, que te ayudará a crear un nuevo proyecto JavaFX a través de *Maven Archetype*.

<img src="/assets/09_vs02.png" alt="Nuevo Proyecto" style="zoom: 50%;" />

## Ejecutar la aplicación JavaFX

> **nota**: la siguiente guía solo funciona para proyectos administrados por *Maven*. El proyecto generado requiere al menos *JDK 11* para ejecutarlo. Asegúrate de tener *JDK 11* instalado localmente y establecer la ruta de instalación en la configuración [`java.configuration.runtimes`](https://github.com/redhat-developer/vscode-java#project-jdks).

Para ejecutar la aplicación JavaFX, puedes abrir **Maven** Explorer, expandir `hellofx`> `Plugins`> `javafx` y ejecutar el objetivo de Maven: `javafx:run`.

> **nota** : asegúrate de haber instalado la extensión [Maven para Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-maven) . Si no puedes encontrar el explorador **Maven**, abre la paleta de comandos ( Ctrl+Shift+P ) y luego selecciona el comando **Explorador: centrarse en la vista Maven** .



Una vez que se establece el `classpath`, el IDE reconocerá las clases `JavaFX`.

Por ejemplo, vamos comenzar:

1. heredando la clase principal de la clase `Application`.
2. tendremos que importar las clases de la librería.
3. implementar el método abstracto, añadir el `launch()` al `main()` y añadir los imports necesarios.

```java
package holafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HolaFX extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXML HolaFX.fxml"));
        stage.setTitle("Hola Mundo");
        stage.setScene(new Scene(root));
        stage.show();
    }
    
}
```



## Prueba final de la aplicación

Si hemos seguido todos los pasos correctamente, podremos ejecutar nuestra aplicación y ver la ventana titulada "Hola Mundo":

<img src="/assets/NB11.png" alt="Hola Mundo" style="zoom:50%;" />

# Píldoras informáticas relacionadas

- https://www.youtube.com/playlist?list=PLNjWMbvTJAIjLRW2qyuc4DEgFVW5YFRSR
- https://www.youtube.com/playlist?list=PLaxZkGlLWHGUWZxuadN3J7KKaICRlhz5-

# Fuentes de información

- Apuntes de Jose Antonio Diaz-Alejo
- https://github.com/openjfx/openjfx-docsopen
- https://github.com/openjfx/samples
- [FXDocs](https://github.com/FXDocs/docs)
- https://openjfx.io/openjfx-docs/
- https://docs.oracle.com/javase/8/javafx/user-interface-tutorial
- https://github.com/JonathanGiles/scenic-view
