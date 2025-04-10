Para un parcial donde trabajas con colas (queues) en Java como en tu código del banco, estos son los métodos clave que necesitas saber, especialmente si usas la clase LinkedList como implementación de Queue:


---

🧠 Métodos fundamentales de una cola (Queue)


---

📚 Ejemplo visual de cómo se comporta

Queue<String> cola = new LinkedList<>();

cola.offer("A");
cola.offer("B");
cola.offer("C");

System.out.println(cola.peek()); // A (no lo elimina)
System.out.println(cola.poll()); // A (sí lo elimina)
System.out.println(cola);        // [B, C]


---

🚨 Diferencias importantes


---

🔍 Para tu parcial, enfócate especialmente en:

offer → para agregar.

poll → para eliminar o atender.

peek → para ver el primero sin eliminarlo.

isEmpty → para evitar errores cuando haces poll o peek.

Saber usar un for-each para recorrer la cola.



---

¿Quieres que te arme una mini-guía o hoja de trucos para repasar antes del parcial?

  
