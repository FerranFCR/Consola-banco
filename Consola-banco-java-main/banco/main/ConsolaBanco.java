package banco.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import banco.modelos.Cliente;
import banco.modelos.Gestor;
import banco.modelos.Mensaje;
import banco.modelos.Transferencia;
import banco.util.Utiles;

public class ConsolaBanco {

	// atributos de la clase consola
	private List<Transferencia> transferencia;
	private List<Mensaje> mensajes;
	private List<Gestor> gestores;
	private List<Cliente> clientes;
	private Integer siguienteIdGestor;
	private Scanner teclado;
	private Integer siguienteIdCliente;
	private Integer siguienteIdMensaje;
	private Integer siguienteIdTransferencia;

	ConsolaBanco() {
		this.gestores = new ArrayList<>();
		this.siguienteIdGestor = 1;
		this.teclado = new Scanner(System.in);
		this.clientes = new ArrayList<>();
		this.siguienteIdCliente = 1;
		this.transferencia = new ArrayList<>();
		this.mensajes = new ArrayList<>(); // Agregar esta línea para inicializar la lista de mensajes
		this.siguienteIdMensaje = 1; // Agregar esta línea para inicializar el siguiente ID de mensaje
		this.siguienteIdTransferencia = 1;
	}

	private void menuGestor() {
		System.out.println("\n1. Insertar gestor");
		System.out.println("2. Insertar gestores de prueba");
		System.out.println("3. Consultar gestor");
		System.out.println("4. Ver todos los gestores");
		System.out.println("5. Actualizar gestor");
		System.out.println("6. Eliminar un gestor");
		System.out.println("7. Insertar cliente");
		System.out.println("8. Consultar cliente");
		System.out.println("9. Ver todos los clientes");
		System.out.println("10. Actualizar clientes");
		System.out.println("11. Eliminar un cliente");
		System.out.println("12. Consultar mensaje");
		System.out.println("13. Consultar mensajes");
		System.out.println("14. Envíar mensaje");
		System.out.println("15. Consultar transferencia");
		System.out.println("16. Consultar transferencias");
		System.out.println("17. Envíar transferencia");
		System.out.println("18. Login");
		System.out.println("0. Salir\n");
	}

	private void login() {
		System.out.print("Id gestor: ");
		int idGestor = teclado.nextInt();
		System.out.print("Contraseña: ");
		String pass = teclado.next();
		Gestor gestor = buscarGestorPorId(idGestor);
		// si el gestor existe
		if (gestor != null) {
			// si el gestor existe
			if (gestor.getPassword().equals(pass)) {
				System.out.println("Login correcto!");
			} else {
				System.out.println("Login incorrecto!");
			}
		} else {
			System.out.println("El usuario no existe...");
		}
	}

	private void insertarGestor() {
		System.out.print("Nombre: ");
		String nombre = teclado.next();
		System.out.print("Email: ");
		String email = teclado.next();
		System.out.print("Contraseña: ");
		String pass = teclado.next();
		System.out.print("Oficina: ");
		String oficina = teclado.next();
		Gestor nuevoGestor = new Gestor(siguienteIdGestor, nombre, pass, email, oficina);
		gestores.add(nuevoGestor);
		siguienteIdGestor++;
		System.out.println("Gestor creado con éxito.");
	}

	private void insertarGestores() {
		System.out.print("Número de gestores: ");
		int numeroGestores = teclado.nextInt();
		for (int i = 0; i < numeroGestores; i++) {
			String usuario = Utiles.nombreAleatorio();
			String correo = Utiles.correoAleatorio();
			Gestor gestor = new Gestor(siguienteIdGestor, usuario, "", correo, "Valencia");
			gestores.add(gestor);
			siguienteIdGestor++;
		}
	}

	private void consultarGestor() {
		System.out.print("Id del gestor a consultar: ");
		int idGestor = teclado.nextInt();
		Gestor gestorResultado = buscarGestorPorId(idGestor);
		// si se ha encontrado
		if (gestorResultado != null) {
			System.out.println(gestorResultado);
		} else {
			System.out.println("No se pudo encontrar un gestor con el id " + idGestor);
		}
	}

	private Gestor buscarGestorPorId(int idGestor) {
		Gestor gestorResultado = null;
		for (int i = 0; i < gestores.size(); i++) {
			Gestor gestor = gestores.get(i);
			if (gestor.getId() == idGestor) {
				gestorResultado = gestor;
				// como ya lo hemos encontrado, rompemos el bucle
				return gestorResultado;
			}
		}
		return null;
	}

	private void verGestores() {
		if (gestores.isEmpty()) {
			System.out.println("Todavía no hay gestores.");
		}
		gestores.forEach(gestor -> {
			System.out.println(gestor);
		});
	}

	private void actualizarGestor() {

		System.out.print("Id del gestor a actualizar: ");
		int idGestor = teclado.nextInt();
		Gestor gestorResultado = buscarGestorPorId(idGestor);
		int posicionGestor = -1;
		for (int i = 0; i < gestores.size(); i++) {
			Gestor gestor = gestores.get(i);
			if (gestor.getId() == idGestor) {
				gestorResultado = gestor;
				posicionGestor = i;
				// como ya lo hemos encontrado, rompemos el bucle
				break;
			}
		}
		// si se ha encontrado
		if (gestorResultado != null) {
			System.out.println(gestorResultado);
			System.out.println("[n] Nombre");
			System.out.println("[e] Email");
			System.out.println("[c] Contraseña");
			System.out.println("[o] Oficina");
			System.out.println("[x] Cancelar");
			System.out.print("Campo a actualizar: ");
			char opcionActualizar = teclado.next().charAt(0);
			switch (opcionActualizar) {
			case 'n':
				System.out.print("Nombre: ");
				String nombre = teclado.next();
				gestorResultado.setUsuario(nombre);
				break;
			case 'e':
				System.out.print("Email: ");
				String email = teclado.next();
				gestorResultado.setCorreo(email);
				break;
			case 'c':
				System.out.print("Contraseña: ");
				String pass = teclado.next();
				gestorResultado.setPassword(pass);
				break;
			case 'o':
				System.out.print("Oficina: ");
				String oficina = teclado.next();
				gestorResultado.setOficina(oficina);
				break;
			case 'x':
				System.out.print("Cancelando actualización...");
				break;
			default:
				System.out.println("Opción no válida.");
			}
			if (opcionActualizar != 'x') {
				gestores.set(posicionGestor, gestorResultado);
				System.out.println("Se actualizó el gestor con el id " + idGestor);
			}
		} else {
			System.out.println("No se pudo encontrar un gestor con el id " + idGestor);
		}
	};

	private void eliminarGestor() {
		System.out.print("Id del gestor a eliminar: ");
		int idGestor = teclado.nextInt();
		Gestor gestorResultado = null;
		int posicionGestor = -1;
		for (int i = 0; i < gestores.size(); i++) {
			Gestor gestor = gestores.get(i);
			if (gestor.getId() == idGestor) {
				gestorResultado = gestor;
				posicionGestor = i;
				// como ya lo hemos encontrado, rompemos el bucle
				break;
			}
		}
		// si se ha encontrado
		if (gestorResultado != null) {
			gestores.remove(posicionGestor);
			System.out.println("Se eliminó el gestor con el id " + idGestor);
		} else {
			System.out.println("No se pudo encontrar un gestor con el id " + idGestor);
		}
	}

	private void cerrar() {
		teclado.close();
		System.out.println("¡Hasta pronto!");
	}

	private void insertarCliente() {
		System.out.print("Nombre: ");
		String nombre = teclado.next();
		System.out.print("Email: ");
		String email = teclado.next();
		System.out.print("Contraseña: ");
		String pass = teclado.next();
		System.out.print("Saldo: ");
		Double saldo = teclado.nextDouble();
		System.out.print("id gestor: ");
		Integer idGestor = teclado.nextInt();

		Cliente nuevoCliente = new Cliente(siguienteIdCliente, nombre, email, pass, saldo, idGestor);
		clientes.add(nuevoCliente);
		siguienteIdCliente++;
		System.out.println("Cliente creado con éxito.");
	}

	private void consultarCliente() {
		System.out.print("Id del cliente a consultar: ");
		int idCliente = teclado.nextInt();
		Cliente clienteResultado = buscarClientePorId(idCliente);
		// si se ha encontrado
		if (clienteResultado != null) {
			System.out.println(clienteResultado);
		} else {
			System.out.println("No se pudo encontrar un cliente con el id " + idCliente);
		}
	}

	private Cliente buscarClientePorId(int idCliente) {
		Cliente clienteResultado = null;
		for (int i = 0; i < clientes.size(); i++) {
			Cliente cliente = clientes.get(i);
			if (cliente.getId() == idCliente) {
				clienteResultado = cliente;
				// como ya lo hemos encontrado, rompemos el bucle
				return clienteResultado;
			}
		}
		return null;
	}

	private void verClientes() {
		if (clientes.isEmpty()) {
			System.out.println("Todavía no hay clientes.");
		}
		clientes.forEach(cliente -> {
			System.out.println(cliente);
		});
	}

	private void actualizarCliente() {
		System.out.print("Id del cliente a actualizar: ");
		int idCliente = teclado.nextInt();
		Cliente clienteResultado = buscarClientePorId(idCliente);
		int posicionCliente = -1;
		for (int i = 0; i < clientes.size(); i++) {
			Cliente cliente = clientes.get(i);
			if (cliente.getId() == idCliente) {
				clienteResultado = cliente;
				posicionCliente = i;
				// como ya lo hemos encontrado, rompemos el bucle
				break;
			}
		}
		// si se ha encontrado
		if (clienteResultado != null) {
			System.out.println(clienteResultado);
			System.out.println("[n] Nombre");
			System.out.println("[e] Email");
			System.out.println("[c] Contraseña");
			System.out.println("[s] Saldo");
			System.out.println("[g] Id Gestor");
			System.out.println("[x] Cancelar");
			System.out.print("Campo a actualizar: ");
			char opcionActualizar = teclado.next().charAt(0);
			switch (opcionActualizar) {
			case 'n':
				System.out.print("Nombre: ");
				String nombre = teclado.next();
				clienteResultado.setUsuario(nombre);
				break;
			case 'e':
				System.out.print("Email: ");
				String email = teclado.next();
				clienteResultado.setCorreo(email);
				break;
			case 'c':
				System.out.print("Contraseña: ");
				String pass = teclado.next();
				clienteResultado.setPassword(pass);
				break;
			case 's':
				System.out.print("Saldo: ");
				double saldo = teclado.nextDouble();
				clienteResultado.setSaldo(saldo);
				break;
			case 'g':
				System.out.print("Id Gestor: ");
				int idGestor = teclado.nextInt();
				clienteResultado.setIdGestor(idGestor);
				break;
			case 'x':
				System.out.print("Cancelando actualización...");
				break;
			default:
				System.out.println("Opción no válida.");
			}
			if (opcionActualizar != 'x') {
				clientes.set(posicionCliente, clienteResultado);
				System.out.println("Se actualizó el cliente con el id " + idCliente);
			}
		} else {
			System.out.println("No se pudo encontrar un cliente con el id " + idCliente);
		}
	};

	private void eliminarCliente() {
		System.out.print("Id del cliente a eliminar: ");
		int idCliente = teclado.nextInt();
		Cliente clienteResultado = null;
		int posicionCliente = -1;
		for (int i = 0; i < clientes.size(); i++) {
			Cliente cliente = clientes.get(i);
			if (cliente.getId() == idCliente) {
				clienteResultado = cliente;
				posicionCliente = i;
				// como ya lo hemos encontrado, rompemos el bucle
				break;
			}
		}
		// si se ha encontrado
		if (clienteResultado != null) {
			clientes.remove(posicionCliente);
			System.out.println("Se eliminó el cliente con el id " + idCliente);
		} else {
			System.out.println("No se pudo encontrar un cliente con el id " + idCliente);
		}
	}

	private void consultarMensaje() {
		System.out.print("Id del mensaje a consultar: ");
		int idMensaje = teclado.nextInt();
		Mensaje mensajeResultado = buscarMensajePorId(idMensaje);
		// si se ha encontrado
		if (mensajeResultado != null) {
			System.out.println(mensajeResultado);
		} else {
			System.out.println("No se pudo encontrar un mensaje con el id " + idMensaje);
		}
	}

	private Mensaje buscarMensajePorId(int idMensaje) {
		for (Mensaje mensaje : mensajes) {
			if (mensaje.getId() == idMensaje) {
				return mensaje;
			}
		}
		return null; // Si no se encuentra el mensaje con el id especificado
	}

	private void consultarMensajes() {
		if (mensajes.isEmpty()) {
			System.out.println("Todavía no hay mensajes.");
		}
		mensajes.forEach(mensaje -> {
			System.out.println(mensaje);
		});
	}

	private void enviarMensaje() {
		System.out.print("Id del remitente: ");
		int idOrigen = teclado.nextInt();
		System.out.print("Id del destinatario: ");
		int idDestino = teclado.nextInt();
		teclado.nextLine(); // Limpiar el búfer del teclado
		System.out.print("Contenido del mensaje: ");
		String texto = teclado.nextLine();
		Mensaje nuevoMensaje = new Mensaje(siguienteIdMensaje, idOrigen, idDestino, texto);
		mensajes.add(nuevoMensaje);
		siguienteIdMensaje++;
		System.out.println("Mensaje enviado con éxito.");
	}

	private void consultarTransferencia() {
		System.out.print("Id de la transferencia a consultar: ");
		int idTransferencia = teclado.nextInt();
		Transferencia transferenciaResultado = buscarTransferenciaPorId(idTransferencia);
		// si se ha encontrado
		if (transferenciaResultado != null) {
			System.out.println(transferenciaResultado);
		} else {
			System.out.println("No se pudo encontrar una transferencia con el id " + idTransferencia);
		}
	}

	public Transferencia buscarTransferenciaPorId(int idTransferencia) {
		for (Transferencia transferencia : transferencia) {
			if (transferencia.getId() == idTransferencia) {
				return transferencia;
			}
		}
		return null; // Si no se encuentra la transferencia con el ID especificado
	}

	private void consultarTransferencias() {
		if (transferencia.isEmpty()) {
			System.out.println("Todavía no hay transferencias.");
		}
		transferencia.forEach(transferencia -> {
			System.out.println(transferencia);
		});
	}

	private void enviarTransferencia() {
		System.out.print("Id Ordenante: ");
		int idOrdenante = teclado.nextInt();
		System.out.print("Id del beneficiario: ");
		int idBeneficiario = teclado.nextInt();
		System.out.print("Cantidad a transferir: ");
		double importe = teclado.nextDouble();
		System.out.print("Concepto: ");
		teclado.nextLine(); // Consumir el salto de línea pendiente
		String concepto = teclado.nextLine();
		Transferencia nuevaTransferencia = new Transferencia(siguienteIdTransferencia, idOrdenante, idBeneficiario,
				importe, concepto);
		transferencia.add(nuevaTransferencia);
		siguienteIdTransferencia++;
	}

	private void iniciar() {
		int opcion = -1;

		do {
			menuGestor();
			System.out.print("Selecciona una opción: ");

			opcion = teclado.nextInt();

			switch (opcion) {
			case 1:
				insertarGestor();
				break;
			case 2:
				insertarGestores();
				break;
			case 3:
				consultarGestor();
				break;
			case 4:
				verGestores();
				break;
			case 5:
				actualizarGestor();
				break;
			case 6:
				eliminarGestor();
				break;
			case 7:
				insertarCliente();
				break;
			case 8:
				consultarCliente();
				break;
			case 9:
				verClientes();
				break;
			case 10:
				actualizarCliente();
				break;
			case 11:
				eliminarCliente();
				break;
			case 12:
				consultarMensaje();
				break;
			case 13:
				consultarMensajes();
				break;
			case 14:
				enviarMensaje();
				break;
			case 15:
				consultarTransferencia();
				break;
			case 16:
				consultarTransferencias();
				break;
			case 17:
				enviarTransferencia();
				break;
			case 18:
				login();
				break;
			case 0:
				cerrar();
				break;
			default:
				System.out.println("Opción desconocida...");
			}

		} while (opcion != 0);
	}

	public static void main(String[] args) {
		ConsolaBanco consola = new ConsolaBanco();
		consola.iniciar();
	}
}
