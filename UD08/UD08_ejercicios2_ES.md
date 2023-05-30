---
unit: UD08
title: Ejercicios Alternativos
language: ES
author: Arturo Blasco
subject: Programación
keywords: [PRG, 2022, Programacion, Java]
IES: IES Mestre Ramon Esteve (Catadau) [www.iesmre.com]
header: ${title} - ${subject} (ver. ${today}) 
footer:${currentFileName}.pdf - ${author} - ${IES} - ${pageNo}/${pageCount}
typora-root-url:${filename}/../
typora-copy-images-to:${filename}/../assets
---
[toc]



# Ejercicios alternativos

*Práctica con interfaces y polimorfismo*

## Ejercicio Supermercado

**Supermercado. Creación de Interfaces**

Supón que debes crear distintas clases Java para describir los productos que vende un supermercado.

Para unificar el código de los distintos programadores del equipo debes crear las siguientes Interfaces Java para describir algunas características de los productos.

**Interfaz EsLiquido**

Esta interfaz indica que los objetos creados a partir de la clase serán líquidos, y tendrá los siguientes métodos:

```java
public void setVolumen(double v);
public double getVolumen();
public void setTipoEnvase(String env);
public String getTipoEnvase();
```

**Interfaz EsAlimento**

Esta interfaz indica que los objetos creados a partir de la clase serán alimentos, y tendrá los siguientes métodos:

```java
public void setCaducidad(LocalDate fc);
public LocalDate getCaducidad();
public int getCalorias();
```

**Interfaz ConDescuento**

Esta interfaz indicará que el producto tiene descuento e incluirá los siguientes métodos:

```java
public void setDescuento(double des);
public double getDescuento();
public double getPrecioDescuento();
```



**Creación de clases de productos**

Se pide que programes las siguientes clases de productos, implementando las interfaces que sean necesarias.

**Clase Detergente**

Define una botella de detergente (debes tener en cuenta que este producto puede tener descuento).

Sus propiedades principales serán:

- `marca (String)` y `precio (double)`.

Incluye otras propiedades según sea necesario a la hora de implementar las interfaces.

- *Constructor*: programa un constructor que reciba como parámetros una marca y un precio.

- Métodos *set* y *get*: programa métodos set y get para la marca y el precio.

- Métodos de las interfaces: programa los métodos de las interfaces.
- Método *toString*: programa el método toString con todas las características del producto.

**Clase Cereales**

Define el producto caja de cereales (este producto no tiene descuentos).

Las propiedades del producto serán `marca`, `precio` y `tipo` de cereal (*String*).

- Programa un *constructor* que reciba como parámetros las tres propiedades
  anteriores.
- Programa los métodos *set* y *get* para dichas propiedades.
- Programa los métodos de las interfaces implementadas (si es necesario añade más propiedades a la clase).

> **A tener en cuenta**: las calorías serán las siguientes: 5 si el cereal es espelta, 8 si es maíz, 12 si es trigo, y 15 en los demás casos.

- Programa el método *toString* para devolver una cadena con todas las características del producto.

**Clase Vino**

Esta clase describirá el producto botella de vino. (Este producto es susceptible de tener descuento).

El producto tendrá como propiedades la `marca`, el `tipo` de vino, los `gradosAlcohol` y el `precio`.

- Programa al igual que los productos anteriores un *constructor* con estas cuatro propiedades como parámetros.
- Programe también los métodos *set*, *get*, *toString* y los métodos de las interfaces. Añade nuevas propiedades si es necesario.

> **A tener en cuenta**: las calorías se calcularán multiplicando por 10 la graduación alcohólica.

**Programa de prueba**

Realiza un programa de prueba dónde se cree varios productos de cada clase.

Haz un ejemplo de polimorfismo creando un ArrayList de productos alimenticios y calculando la suma de sus calorías.