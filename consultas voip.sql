SELECT id, id_usuario, tipo, saldo
	FROM public.cuenta_bancaria;
	
SELECT id, id_cuenta_origen, id_cuenta_destino, monto, fecha
	FROM public.transacciones_bancarias;
	
SELECT id, nombre, apellido, email, direccion
	FROM public.usuario;