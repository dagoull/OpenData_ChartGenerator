# OpenDataChartGenerator-ODCG
## Proyecto final de la asignatura Laboratorio de Desarrollo y Herramientas.
Para el desarrollo del proyecto se hará grupo, este está formado por:
* [Orlandy Ariel Ariel Sánchez](https://github.com/alu0100773408)
* [Joel Perez Ramos](https://github.com/alu0100723304)
* [Mauricio José Orta Rodríguez](https://github.com/mauriciojorta)
* [Angel Rodriguez Negrin](https://github.com/alu0100782974)

Dado que necesitamos generar gráficos utilizaremos la herramienta denomina [JFreeChart](http://www.jfree.org/jfreechart/).
JFreeChart es un marco de software open source para el lenguaje de programación Java, el cual permite la creación de gráficos complejos de forma simple.

JFreeChart trabaja con GNU Classpath, una implementación en software libre de la norma estándar de biblioteca de clases para el lenguaje de programación Java.
JFreeChart es compatible con una serie de gráficas diferentes, incluyendo cuadros combinados. Estos gráficos son:
   * Gráficos XY.
   * Gráfico circular.
   * Diagrama de Gantt.
   * Gráficos de barras (Histogramas).
   * Single valued (Termómetro, brújula, indicador de velocidad).

### Para el uso la librería, se utiliza (mediante [Maven](https://maven.apache.org/))
```xml
<!-- https://mvnrepository.com/artifact/org.jfree/jfreechart -->
		<dependency>
			<groupId>org.jfree</groupId>
			<artifactId>jfreechart</artifactId>
			<version>1.0.14</version>
		</dependency>
```

### Inicialmente se da divido en tres grandes módulos de desarrollo.

**Entradas**
  * Vamos a desarrollar una aplicación que tendrá datos de entrada Datos Abiertos (Open Data), tales que los formatos de dichos ficheros van a ser:
  	*  “.ASCII”
  	*  “.cvs”
  	*  “.xls”.

**Proceso**
   * Normalizar y formalizar los datos a un formato comprensible para JFreeChart.
   * Gestión del procesamiento de la salida.

**Salidas**
   * Gestiona la salida dando la posibilidad de mostrar la información en distintos formatos al usuario, como son:
   	* Diagrama de barras
   	* Diagrama de pastel
   	* Información mediante la consola
   	* Imprirmir en pdf (imprime la opcioón elegida de las anteriores)

Para la gestión de la documentación se hace uso de la herramienta [Doxygen](http://www.stack.nl/~dimitri/doxygen/)
Así tambien para la gestión del proyecto en general se hace uso de la herramienta de gestión de proyectos [Taiga](https://taiga.io/)

