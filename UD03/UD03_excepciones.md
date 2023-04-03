---
unit: UD03
title: Anexo I - Excepciones
language: ES
author: Arturo Blasco [arturoblasco@iesmre.com]
subject: Programación
keywords: [PRG, 2022, Programacion, Java]
IES: IES Mestre Ramón Esteve (Catadau) [iesmre.es]
header: ${unit}: ${title} - ${subject} (ver: ${today})
footer: ${currentFileName}.pdf - ${author} - ${IES} - ${pageNo}/${pageCount}
typora-root-url:${filename}/../
typora-copy-images-to:${filename}/../assets
---
[toc]

# Qué son las excepciones

Cuando un programa Java viola las restricciones semánticas del lenguaje (se produce un error) la máquina virutal Java comunica este hecho al programa **mediante una excepción**.

Muchas tipos de errores pueden provocar una excepción: un desbordamiento de memoria, un disco duro estropeado, un intento de dividir por cero o intentar acceder a un vector fuera de sus límites. 

Cuando esto ocurre, la máquina virtual Java **crea un objeto de clase Exception**.

**Ejemplo 1**:

```java
public class PruebaExcepciones {
  
   public static void main(String[] args) {
       int numero1 = 5, numero2 = 0;

       int resultado = numero1 / numero2;

       System.out.println("El resultado es: " +  resultado);
   }
}
```

En el anterior ejemplo, Java no detecta un error en la línea de código 6 (aunque sabemos que no se podría realizar esta operación).

Mostrará la siguiente excepción (`ArihtmeticException` del paquete **lang**) en línea de ejecución:

```sh
Exception in thread "main" java.lang.ArithmeticException: / by zero
        at PruebaExcepciones.main(PruebaExcepciones.java:6)
```

Si accedemos a la información de la API de Java en la web, podemos comprobar que, en el paquete `java.lang`, encontramos, en su sección de excepciones, la excepción *ArithmeticException*; que hereda de la clase Exception.

<img src="/assets/image-20230403091610370.png" alt="image-20230403091610370" style="zoom:80%;" />



Siguiendo con el ejemplo 1, ¿qué ocurriría si añadimos más líneas de código justo después de la línea de código que provoca una excepción aritmética?

```java
public class PruebaExcepciones {

   public static void main(String[] args) {
       	int numero1 = 5, numero2 = 0;int resultado = numero1 / numero2;

   		System.out.println("El resultado es: " +  resultado);

   		System.out.println("Adiós");  // se añade más código ...
   }
}
```
El siguiente código provocaría, exactamente, la misma excepción; y la ejecución pararía en el mismo punto, mostrando el mismo código que el ejemplo anterior. Además, la línea 8 ya no se mostraría:

```sh 
Exception in thread "main" java.lang.ArithmeticException: / by zero
        at PruebaExcepciones.main(PruebaExcepciones.java:6)
```

**Ejemplo 2**: ¿Qué resultado mostrará el siguiente código si al ejecutarlo introducimos un número en forma de cadena?

```java
import java.util.Scanner;

public class PruebaExcepciones {
  
   public static void main(String[] args) {
       Scanner entrada = new Scanner(System.in);
      
       System.out.print("Introduce un número entero: ");
       int numero = entrada.nextInt();

       System.out.println(numero);
   }
}
```

```sh
Introduce un número entero: quince
```

Mostrará la siguiente excepción (`InputMismatchException` del paquete **util**) en línea de ejecución:

```sh
Exception in thread "main" java.util.InputMismatchException
…
        at PruebaExcepciones.main(PruebaExcepciones.java:9)
```

Si accedemos a la información de la API de Java en la web, podemos comprobar que, en el paquete `java.util`, encontramos, en su sección de excepciones, la excepción *InputMismatchException*; que también hereda, por supuesto, de la clase Exception.

<img src="/assets/image-20230403092950634.png" alt="image-20230403092950634" style="zoom:80%;" />



El manejo de excepciones **va a permitir que el programa no se “frene”**, evadiendo los diferentes errores que encuentre para que, el código que existe después de la línea de error, se pueda ejecutar sin problemas.

# Jerarquía de excepciones

<img src="/assets/image-20230403093301428.png" alt="image-20230403093301428" style="zoom:80%;" />

En la jerarquía que ofrece Java para los objetos Exception (excepciones) se puede observar que Exception hereda de la clase Throwable que, a la vez y como todas las clases en Java, hereda de la clase Object.

A partir de la clase `Throwable` se tienen dos tipos de clases. Por una parte la clase `Error` en la que encontraríamos errores más comunes al ámbito hardware; y por otra la clase `Exception`(clase de la que hablaremos a continuación y de la que dependen más los errores software).

De la clase `Exception` heredan otros dos tipos de clases:

- La clase `IOException`: que tratará excepciones verificadas, y que Java nos obliga a tratar de evitar. No dependen directamente del programador (aunque sí se puede solucionar). 

   Tienen más que ver con las entradas-salidas de los programas. Un ejemplo podría ser que, por error, el usuario haya borrado una carpeta o fichero del que depende el propio programa.

- La clase `RunTimeException`: que tratará excepciones NO verificadas y que dependerán más del programador. Ejemplos de este tipo de errores serían dividir un número entero entre cero, o guardar un String dentro de un valor entero.

> Estos tipos de errores Java no obliga a evadir estos errores. En cambio, los errores que generan objetos de la clase IOException sí que estaremos obligados a evitar.



**Ejemplo 3**: Las siguientes líneas de código muestran una **excepción verificada**. En estas, se desea leer un fichero debería encuentrarse en una ruta determinada ("/home/abc/texto.txt") pero que no existe:

```java
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PruebaExcepciones {
  
    public static void main(String[] args) throws FileNotFoundException, IOException {
       // Excepciones verificadas (IOException)
       BufferedReader bf = new BufferedReader(new FileReader("/home/abc/texto.txt"));
       String linea;
       while ((linea = bf.readLine()) != null){
        System.out.println(linea);
       }
    }
} 
```

```sh
Exception in thread "main" java.io.FileNotFoundException: /home/abc/textos.txt (No such file or directory)
        at java.base/java.io.FileInputStream.open0(Native Method)
        at java.base/java.io.FileInputStream.open(FileInputStream.java:219)
        at java.base/java.io.FileInputStream.<init>(FileInputStream.java:157)
        at java.base/java.io.FileInputStream.<init>(FileInputStream.java:112)
        at java.base/java.io.FileReader.<init>(FileReader.java:60)
        at UD06.PruebaExcepciones.main(PruebaExcepciones.java:10)
```

Se observa que en la línea 10 de `PruebaExcepciones` mostrará el mensaje de excepción FileNotFoundException.

Cuando exista una excepción verificada, tendremos dos formas de tratamiento de ésta:

1. Declarar la excepción que se puede dar en el método.

   En la misma declaración del método que puede provocar el error se introducen las excepciones:

   ```java
   public static void main(String[] args) throws FileNotFoundException, IOException {
   ```

2. Capturarla con un try-catch.

```java
...
try {
      while ((linea = bf.readLine()) != null){
          System.out.println(linea);
      }
} catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
}
...
```


**Ejemplo 4**: En el siguiente código:

```java
import java.io.File;
import java.io.FileReader;

public class PruebaExcepciones {
  
 public void leerArchivo(){
   File archivo = new File("/home/abc/texto.txt");
   FileReader fr = new FileReader(archivo); Unhandled exception type FileNotFoundException
 }
    
 public static void main(String[] args) {
 }
}
```

En la línea 8 aparece un mensaje (*Unhandled exception type FileNotFoundException*) en el que nos indica que no hemos tratado este tipo de excepción, del tipo FileNotFoundException que hereda de IOException:

<img src="/assets/image-20230403101322542.png" style="zoom:80%;" /> 

Si, en Visual Studio Code, pulsamos en el icono azul (en otros IDEs como Eclipse también aparecen este tipo de advertencias) nos ofrece dos tipos de opciones para manejar el error/excepción:

- `Add throws declaration` , en la que se declara la excepción en la misma declaración del método y se importa la clase *java.io.FileNotFoundException*, o

- `Surround with try/catch`, en la que introduce un bloque de código que va a contener la excepción.

## Declaración de excepciones de un método

Si elegimos la primera opción, declarar:

```java
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class PruebaExcepciones {

   public void leerArchivo()throws FileNotFoundException{
       File archivo = new File("/home/abc/texto.txt");
       FileReader fr = new FileReader(archivo);   
   }
   public static void main(String[] args) {

   }
}
```

> **Recuerda**:
>
> Utilizaremos la declaración de excepciones cuando en dicho método no se quiere capturar el error, sino que dicho método se va a utilizar en otro método (en este otro ya se capturaría el error).
>
> ```java
> import java.io.File;
> import java.io.FileReader;
> import java.io.FileNotFoundException;
> 
> public class PruebaExcepciones {
>    public void leerArchivo()throws FileNotFoundException{
>        File archivo = new File("/home/abc/texto.txt");
>        FileReader fr = new FileReader(archivo);   
>    }
>    public void leerArchivo2(){
>        leerArchivo(); 
>    }
>    public static void main(String[] args) {
>    }
> }
> ```

## try/catch en excepciones verificadas

Esta opción se utilizará para usar, desde otro método, una excepción que hayamos declarado. En este ejemplo:

```java
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class PruebaExcepciones {
   public static void leerArchivo()throws FileNotFoundException{
       File archivo = new File("/home/abc/texto.txt");
       FileReader fr = new FileReader(archivo);   
   }
   public static void leerArchivo2(){
	   try {
	        leerArchivo(); 
	   } catch (FileNotFoundException ex){
    		JOptionPane.showMessageDialog(null, "archivo no encontrado");	           
	   } catch (IOException ex) {
    		JOptionPane.showMessageDialog(null, "ha ocurrido una excepción verificada");	           
       }     
   }
   public static void main(String[] args) {
	   leerArchivo2();
   }
}
```

El método *leerArchivo2()* usa el método *leerArchivo()*. Como *leerArchivo()* tiene una excepción en su declaración, en *leerArchivo2()* vamos a intentar capturarla (catch). Además, como tenemos dos tipos de excepciones, vamos a tener de capturar estas dos. Se da el caso que FileNotFoundException hereda de IOException; por lo que sería correcto capturar solo la excepción IOException. Pero es recomendable capturar los dos tipos; y además con el orden de: la clase más cercana.

# Fuentes de información

- [Wikipedia](https://es.wikipedia.org)

- [Udemy - Aprende Programación en Java (de Básico a Avanzado)](https://www.udemy.com/) ]

   

