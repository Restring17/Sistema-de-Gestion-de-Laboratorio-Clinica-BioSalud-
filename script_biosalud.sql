-- ===============================================
-- SCRIPT PARA LA BASE DE DATOS DE APPBIOSALUD
-- ===============================================

CREATE DATABASE IF NOT EXISTS appbiosalud;
USE appbiosalud;

-- ========================
-- TABLA PACIENTE
-- ========================
CREATE TABLE paciente (
  id_paciente INT AUTO_INCREMENT PRIMARY KEY,
  dni VARCHAR(20) UNIQUE NOT NULL,
  nombres VARCHAR(100) NOT NULL,
  apellidos VARCHAR(100) NOT NULL,
  fecha_nacimiento DATE,
  telefono VARCHAR(50),
  email VARCHAR(100)
);

-- ========================
-- TABLA MEDICO
-- ========================
CREATE TABLE medico (
  id_medico INT AUTO_INCREMENT PRIMARY KEY,
  nombres VARCHAR(100),
  apellidos VARCHAR(100),
  especialidad VARCHAR(100),
  cmp VARCHAR(50),
  telefono VARCHAR(50)
);

-- ========================
-- TABLA USUARIO
-- ========================
CREATE TABLE usuario (
  id_usuario INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) UNIQUE NOT NULL,
  password_hash VARCHAR(64) NOT NULL,
  rol VARCHAR(20)
);

-- ========================
-- TABLA TECNICO LABORATORIO
-- ========================
CREATE TABLE tecnico_laboratorio (
  id_tecnico INT AUTO_INCREMENT PRIMARY KEY,
  nombres VARCHAR(100) NOT NULL,
  apellidos VARCHAR(100) NOT NULL,
  especialidad VARCHAR(100),
  telefono VARCHAR(50)
);

-- ========================
-- TABLA ORDEN DE LABORATORIO
-- ========================
CREATE TABLE orden_laboratorio (
  id_orden INT AUTO_INCREMENT PRIMARY KEY,
  fecha_orden DATETIME,
  tipo_examen VARCHAR(255),
  observaciones TEXT,
  id_paciente INT,
  id_medico INT,
  estado VARCHAR(50) DEFAULT 'PENDIENTE',
  FOREIGN KEY (id_paciente) REFERENCES paciente(id_paciente),
  FOREIGN KEY (id_medico) REFERENCES medico(id_medico)
);

-- ========================
-- TABLA TOMA DE MUESTRA
-- ========================
CREATE TABLE toma_muestra (
  id_muestra INT AUTO_INCREMENT PRIMARY KEY,
  fecha_hora DATETIME,
  tipo_muestra VARCHAR(50),
  id_orden INT,
  id_tecnico INT,
  FOREIGN KEY (id_orden) REFERENCES orden_laboratorio(id_orden),
  FOREIGN KEY (id_tecnico) REFERENCES tecnico_laboratorio(id_tecnico)
);

-- ========================
-- TABLA RESULTADO DE LABORATORIO
-- ========================
CREATE TABLE resultado_laboratorio (
  id_resultado INT AUTO_INCREMENT PRIMARY KEY,
  fecha_resultado DATETIME,
  descripcion TEXT,
  valores_json TEXT,
  conclusiones TEXT,
  id_orden INT,
  validado BOOLEAN DEFAULT FALSE,
  FOREIGN KEY (id_orden) REFERENCES orden_laboratorio(id_orden)
);

-- ========================
-- TABLA FACTURA
-- ========================
CREATE TABLE factura (
  id_factura INT AUTO_INCREMENT PRIMARY KEY,
  fecha_emision DATETIME,
  monto_total DECIMAL(10,2),
  metodo_pago VARCHAR(50),
  id_paciente INT,
  FOREIGN KEY (id_paciente) REFERENCES paciente(id_paciente)
);
-- ========================
-- TABLA DETALLE FACTURA
-- ========================
CREATE TABLE detalle_factura (
  id_detalle INT AUTO_INCREMENT PRIMARY KEY,
  id_factura INT,
  descripcion_servicio VARCHAR(255),
  cantidad INT,
  precio_unitario DECIMAL(10,2),
  FOREIGN KEY (id_factura) REFERENCES factura(id_factura)
);

-- =======================
-- TABLA ROL 
-- ======================
CREATE TABLE rol (
    id_rol INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) UNIQUE NOT NULL
);

-- ==============================
-- USUARIO ADMINISTRADOR
-- ==============================
INSERT INTO usuario (username, password_hash, rol)
VALUES (
    'admin',
    SHA2('admin123', 256),
    'ADMIN'
);

-- ======================================
-- MODIFICACIONES NECESARIAS
-- ======================================

-- Modificaciones tabla usuario
ALTER TABLE usuario 
ADD COLUMN nombre VARCHAR(100),
ADD COLUMN email VARCHAR(100),
ADD COLUMN estado ENUM('ACTIVO', 'INACTIVO') DEFAULT 'ACTIVO';

-- Modificaciones tabla toma muestra
ALTER TABLE toma_muestra
ADD COLUMN id_paciente INT NOT NULL AFTER id_tecnico,
ADD CONSTRAINT fk_muestra_paciente
  FOREIGN KEY (id_paciente) REFERENCES paciente(id_paciente);

-- ======================================
-- INSERTS
-- ======================================
USE appbiosalud;
-- Inserts para roles
INSERT INTO rol (nombre) VALUES
('ADMIN'),
('RECEPCIONISTA'),
('TECNICO'),
('ASISTENTE'),
('MEDICO'),
('BIOQUIMICO');

INSERT INTO tecnico_laboratorio VALUES
(1,"Juan", "Perez", "Analisita", "98238283");


-- ===============================================
-- PROCEDIMIENTOS ALMACENADOS PARA PACIENTES
-- ===============================================

-- Procedimiento para insertar paciente
DELIMITER //
CREATE PROCEDURE sp_insertar_paciente(
    IN p_dni VARCHAR(20),
    IN p_nombres VARCHAR(100),
    IN p_apellidos VARCHAR(100),
    IN p_fecha_nacimiento DATE,
    IN p_telefono VARCHAR(50),
    IN p_email VARCHAR(100)
)
BEGIN
    INSERT INTO paciente (dni, nombres, apellidos, fecha_nacimiento, telefono, email)
    VALUES (p_dni, p_nombres, p_apellidos, p_fecha_nacimiento, p_telefono, p_email);
END //
DELIMITER ;

-- Procedimiento para actualizar paciente
DELIMITER //
CREATE PROCEDURE sp_actualizar_paciente(
    IN p_id_paciente INT,
    IN p_dni VARCHAR(20),
    IN p_nombres VARCHAR(100),
    IN p_apellidos VARCHAR(100),
    IN p_fecha_nacimiento DATE,
    IN p_telefono VARCHAR(50),
    IN p_email VARCHAR(100)
)
BEGIN
    UPDATE paciente 
    SET dni = p_dni,
        nombres = p_nombres,
        apellidos = p_apellidos,
        fecha_nacimiento = p_fecha_nacimiento,
        telefono = p_telefono,
        email = p_email
    WHERE id_paciente = p_id_paciente;
END //
DELIMITER ;

-- Procedimiento para eliminar paciente
DELIMITER //
CREATE PROCEDURE sp_eliminar_paciente(
    IN p_id_paciente INT
)
BEGIN
    DELETE FROM paciente WHERE id_paciente = p_id_paciente;
END //
DELIMITER ;

-- Procedimiento para buscar paciente por ID
DELIMITER //
CREATE PROCEDURE sp_buscar_paciente_por_id(
    IN p_id_paciente INT
)
BEGIN
    SELECT * FROM paciente WHERE id_paciente = p_id_paciente;
END //
DELIMITER ;

-- Procedimiento para buscar paciente por DNI
DELIMITER //
CREATE PROCEDURE sp_buscar_paciente_por_dni(
    IN p_dni VARCHAR(20)
)
BEGIN
    SELECT * FROM paciente WHERE dni = p_dni;
END //
DELIMITER ;

-- Procedimiento para buscar pacientes por apellidos (búsqueda parcial)
DELIMITER //
CREATE PROCEDURE sp_buscar_paciente_por_apellidos(
    IN p_apellidos VARCHAR(100)
)
BEGIN
    SELECT * FROM paciente WHERE apellidos LIKE p_apellidos;
END //
DELIMITER ;

-- Procedimiento para listar todos los pacientes
DELIMITER //
CREATE PROCEDURE sp_listar_pacientes()
BEGIN
    SELECT * FROM paciente ORDER BY apellidos, nombres;
END //
DELIMITER ;

-- Procedimiento para contar pacientes
DELIMITER //
CREATE PROCEDURE sp_contar_pacientes()
BEGIN
    SELECT COUNT(*) as total FROM paciente;
END //
DELIMITER ;

-- =========================================
-- PROCEDIMIENTOS ALMACENADOS PARA USUARIOS
-- =========================================
USE appbiosalud;
-- Registrar usuario
DELIMITER $$

CREATE PROCEDURE sp_insert_usuario (
    IN p_username VARCHAR(50),
    IN p_password_hash VARCHAR(64),
    IN p_rol VARCHAR(20),
    IN p_nombre VARCHAR(100),
    IN p_email VARCHAR(100)
)
BEGIN
    INSERT INTO usuario(username, password_hash, rol, nombre, email, estado)
    VALUES (p_username, p_password_hash, p_rol, p_nombre, p_email, 'ACTIVO');
END $$
DELIMITER ;

-- Actualizar usuario
DROP PROCEDURE IF EXISTS sp_update_usuario_by_username;
DELIMITER $$

CREATE PROCEDURE sp_update_usuario_by_username(
    IN p_username VARCHAR(50),
    IN p_rol VARCHAR(20),
    IN p_nombre VARCHAR(100),
    IN p_email VARCHAR(100),
    IN p_estado VARCHAR(10)
)
BEGIN
    UPDATE usuario
    SET rol = p_rol,
        nombre = p_nombre,
        email = p_email,
        estado = p_estado
    WHERE username = p_username;
END$$

DELIMITER ;

-- Eliminar usuario
DROP PROCEDURE IF EXISTS sp_eliminar_usuario;

DELIMITER $$

CREATE PROCEDURE sp_eliminar_usuario
(
    IN p_username VARCHAR(50)
)
BEGIN
    DELETE FROM usuario
    WHERE username = p_username;
END $$

DELIMITER ;

-- Procedimiento para buscar usuario por username
DROP PROCEDURE IF EXISTS sp_buscar_usuario_por_username;
DELIMITER $$

CREATE PROCEDURE sp_buscar_usuario_por_username(
    IN p_username VARCHAR(50)
)
BEGIN
    SELECT * 
    FROM usuario
    WHERE username = p_username;
END$$

DELIMITER ;

-- PROCEDIMIENTO: actualizar contraseña por username
DROP PROCEDURE IF EXISTS sp_update_password_by_username;
DELIMITER $$
CREATE PROCEDURE sp_update_password_by_username(
    IN p_username VARCHAR(50),
    IN p_password_hash VARCHAR(64)
)
BEGIN
    UPDATE usuario
    SET password_hash = p_password_hash
    WHERE username = p_username;
END$$
DELIMITER ;

-- PROCEDIMIENTO: listar usuarios
DROP PROCEDURE IF EXISTS sp_listar_usuarios;
DELIMITER $$
CREATE PROCEDURE sp_listar_usuarios()
BEGIN
    SELECT *
    FROM usuario
    ORDER BY id_usuario;
END $$
DELIMITER ;
-- ==============================================
-- PROCEDIMIENTOS ALMACENADOS PARA MEDICOS
-- ==============================================
-- Procedimiento para listar medicos
DELIMITER //
CREATE PROCEDURE sp_medico_listar()
BEGIN
    SELECT * FROM medico;
END //
DELIMITER ;

-- Procedimiento para actualizar medicos
DELIMITER //
CREATE PROCEDURE sp_medico_actualizar(
    IN p_id INT,
    IN p_nombres VARCHAR(100),
    IN p_apellidos VARCHAR(100),
    IN p_especialidad VARCHAR(100),
    IN p_cmp VARCHAR(50),
    IN p_telefono VARCHAR(50)
)
BEGIN
    UPDATE medico
    SET nombres = p_nombres,
        apellidos = p_apellidos,
        especialidad = p_especialidad,
        cmp = p_cmp,
        telefono = p_telefono
    WHERE id_medico = p_id;
END //
DELIMITER ;

-- Procedimiento para contar medicos
DELIMITER //
CREATE PROCEDURE sp_medico_contar(OUT total INT)
BEGIN
    SELECT COUNT(*) INTO total FROM medico;
END //
DELIMITER ;

-- Procedimiento para eliminar medicos
DELIMITER //
CREATE PROCEDURE sp_medico_eliminar(IN p_id INT)
BEGIN
    DELETE FROM medico WHERE id_medico = p_id;
END //
DELIMITER ;

-- Procedimiento para buscar medicos
DELIMITER //
CREATE PROCEDURE sp_medico_obtenerPorID(IN p_id INT)
BEGIN
    SELECT * FROM medico WHERE id_medico = p_id;
END //
DELIMITER ;

-- Procedimiento para registrar medico
DELIMITER //
CREATE PROCEDURE sp_medico_crear(
    IN p_nombres VARCHAR(100),
    IN p_apellidos VARCHAR(100),
    IN p_especialidad VARCHAR(100),
    IN p_cmp VARCHAR(50),
    IN p_telefono VARCHAR(50)
)
BEGIN
    INSERT INTO medico (nombres, apellidos, especialidad, cmp, telefono)
    VALUES (p_nombres, p_apellidos, p_especialidad, p_cmp, p_telefono);
END //
DELIMITER ;

-- procedimiento para insertar medico
DELIMITER //
CREATE PROCEDURE sp_medico_insertar(
    IN p_nombres VARCHAR(100),
    IN p_apellidos VARCHAR(100),
    IN p_especialidad VARCHAR(100),
    IN p_cmp VARCHAR(50),
    IN p_telefono VARCHAR(50)
)
BEGIN
    INSERT INTO medico (nombres, apellidos, especialidad, cmp, telefono)
    VALUES (p_nombres, p_apellidos, p_especialidad, p_cmp, p_telefono);
END //
DELIMITER ;

-- ==========================================
-- PROCEDIMIENTOS ALMACENADOS PARA REPORTES
-- ==========================================
USE appbiosalud;

-- llenar las tablas y operaciones

DELIMITER //
CREATE PROCEDURE sp_reporte_examenes (
  IN p_tipoExamen VARCHAR(255),
  IN p_fechaInicio DATE,
  IN p_fechaFin DATE
)
BEGIN
  -- Definir el patrón de búsqueda para el tipo de examen
  SET @tipoPattern = IF(p_tipoExamen IS NULL OR p_tipoExamen = '', '%', p_tipoExamen);

  -- Tabla 1: Detalle de órdenes (para TablaReportes en Java)
  SELECT 
    o.id_orden, 
    o.tipo_examen, 
    DATE(o.fecha_orden) AS fecha_orden, -- Formateamos la fecha a solo DATE
    DATEDIFF(r.fecha_resultado, o.fecha_orden) AS tiempo_entrega
  FROM orden_laboratorio o
  LEFT JOIN resultado_laboratorio r ON o.id_orden = r.id_orden
  WHERE o.tipo_examen LIKE @tipoPattern -- Usa el patrón de búsqueda
    AND DATE(o.fecha_orden) BETWEEN p_fechaInicio AND p_fechaFin -- Filtro de fecha corregido
  ORDER BY o.fecha_orden;

  -- Tabla 2: Resumen (Totales y Promedio) (para TablaReportes1 en Java)
  SELECT 
    COUNT(o.id_orden) AS total_examenes, -- Contamos las órdenes
    COALESCE(AVG(DATEDIFF(r.fecha_resultado, o.fecha_orden)), 0.0) AS tiempo_promedio -- COALESCE para evitar NULL
  FROM orden_laboratorio o
  LEFT JOIN resultado_laboratorio r ON o.id_orden = r.id_orden
  WHERE o.tipo_examen LIKE @tipoPattern
    AND DATE(o.fecha_orden) BETWEEN p_fechaInicio AND p_fechaFin;
END //
DELIMITER ;

-- [1] PROCEDIMIENTO DE TIPOS DE EXAMEN (CORRECTO)
DROP PROCEDURE IF EXISTS sp_tipos_examen;
DELIMITER //
CREATE PROCEDURE sp_tipos_examen()
BEGIN
  SELECT DISTINCT tipo_examen FROM orden_laboratorio 
  WHERE tipo_examen IS NOT NULL AND tipo_examen <> ''
  ORDER BY tipo_examen;
END //
DELIMITER ;
-- ==============================================
-- PROCEDIMIENTOS ALMACENADOS PARA TOMA MUESTRA 
-- ==============================================
USE appbiosalud;

-- Procedimiento para registrar muestra
DROP PROCEDURE IF EXISTS sp_registrar_muestra;
DELIMITER //
CREATE PROCEDURE sp_registrar_muestra (
    IN p_fecha_hora DATETIME,
    IN p_tipo_muestra VARCHAR(50),
    IN p_id_orden INT,
    IN p_id_tecnico INT,
    IN p_id_paciente INT
)
BEGIN
    INSERT INTO toma_muestra (fecha_hora, tipo_muestra, id_orden, id_tecnico, id_paciente)
    VALUES (p_fecha_hora, p_tipo_muestra, p_id_orden, p_id_tecnico, p_id_paciente);
END //
DELIMITER ;

-- Procedimiento para actualizar muestra
DROP PROCEDURE IF EXISTS sp_actualizar_muestra;
DELIMITER //
CREATE PROCEDURE sp_actualizar_muestra (
    IN p_id_muestra INT,
    IN p_fecha_hora DATETIME,
    IN p_tipo_muestra VARCHAR(50),
    IN p_id_orden INT,
    IN p_id_tecnico INT,
    IN p_id_paciente INT
)
BEGIN
    UPDATE toma_muestra
    SET fecha_hora = p_fecha_hora,
        tipo_muestra = p_tipo_muestra,
        id_orden = p_id_orden,
        id_tecnico = p_id_tecnico,
        id_paciente = p_id_paciente
    WHERE id_muestra = p_id_muestra;
END //
DELIMITER ;
-- Procedimiento para eliminar muestra
DELIMITER //
CREATE PROCEDURE sp_eliminar_muestra (
    IN p_id_muestra INT
)
BEGIN
    DELETE FROM toma_muestra WHERE id_muestra = p_id_muestra;
END //
DELIMITER ;

-- Procedimiento para buscar muestra
DELIMITER //
CREATE PROCEDURE sp_buscar_muestra (
    IN p_id_muestra INT
)
BEGIN
    SELECT *
    FROM toma_muestra
    WHERE id_muestra = p_id_muestra;
END //
DELIMITER ;

-- Procedimiento para buscar muestra por id de orden
DROP PROCEDURE IF EXISTS sp_buscar_muestra_por_orden;
DELIMITER //
CREATE PROCEDURE sp_buscar_muestra_por_orden (
    IN p_id_orden INT
)
BEGIN
    SELECT 
        tm.*, 
        o.id_paciente   -- NUEVO
    FROM toma_muestra tm
    INNER JOIN orden_laboratorio o ON tm.id_orden = o.id_orden
    WHERE tm.id_orden = p_id_orden
    LIMIT 1;
END //
DELIMITER ;

-- Procedimiento para listar muestras
DELIMITER //
CREATE PROCEDURE sp_listar_muestras ()
BEGIN
    SELECT *
    FROM toma_muestra
    ORDER BY id_muestra DESC;
END //
DELIMITER ;
-- ==================================================
-- PROCEDIMIENTOS ALMACENADOS PARA ORDEN LABORATORIO
-- ==================================================
-- INSERTAR ORDEN (devuelve id generado)
DROP PROCEDURE IF EXISTS sp_insertar_orden_laboratorio;
DELIMITER //
CREATE PROCEDURE sp_insertar_orden_laboratorio(
IN p_fecha_orden DATETIME,
IN p_tipo_examen VARCHAR(255),
IN p_observaciones TEXT,
IN p_id_paciente INT,
IN p_id_medico INT
)
BEGIN
INSERT INTO orden_laboratorio(fecha_orden, tipo_examen, observaciones, id_paciente, id_medico, estado)
VALUES (p_fecha_orden, p_tipo_examen, p_observaciones, p_id_paciente, p_id_medico, 'PENDIENTE');
SELECT LAST_INSERT_ID() AS id_orden;
END //
DELIMITER ;

-- ACTUALIZAR ORDEN
DROP PROCEDURE IF EXISTS sp_actualizar_orden_laboratorio;
DELIMITER //
CREATE PROCEDURE sp_actualizar_orden_laboratorio(
IN p_id_orden INT,
IN p_fecha_orden DATETIME,
IN p_tipo_examen VARCHAR(255),
IN p_observaciones TEXT,
IN p_id_paciente INT,
IN p_id_medico INT,
IN p_estado VARCHAR(50)
)
BEGIN
UPDATE orden_laboratorio
SET fecha_orden = p_fecha_orden,
tipo_examen = p_tipo_examen,
observaciones = p_observaciones,
id_paciente = p_id_paciente,
id_medico = p_id_medico,
estado = p_estado
WHERE id_orden = p_id_orden;
END //
DELIMITER ;

-- ELIMINAR ORDEN
DROP PROCEDURE IF EXISTS sp_eliminar_orden_laboratorio;
DELIMITER //
CREATE PROCEDURE sp_eliminar_orden_laboratorio(
IN p_id_orden INT
)
BEGIN
DELETE FROM orden_laboratorio WHERE id_orden = p_id_orden;
END //
DELIMITER ;

-- BUSCAR POR ID
DROP PROCEDURE IF EXISTS sp_buscar_orden_laboratorio;
DELIMITER //
CREATE PROCEDURE sp_buscar_orden_laboratorio(
IN p_id_orden INT
)
BEGIN
SELECT * FROM orden_laboratorio
WHERE id_orden = p_id_orden;
END //
DELIMITER ;

-- LISTAR ORDENES (con paciente y medico)
DROP PROCEDURE IF EXISTS sp_listar_ordenes_laboratorio;
DELIMITER //
CREATE PROCEDURE sp_listar_ordenes_laboratorio()
BEGIN
SELECT o.*,
p.nombres AS paciente_nombres,
p.apellidos AS paciente_apellidos,
m.nombres AS medico_nombres,
m.apellidos AS medico_apellidos
FROM orden_laboratorio o
INNER JOIN paciente p ON o.id_paciente = p.id_paciente
INNER JOIN medico m ON o.id_medico = m.id_medico
ORDER BY o.id_orden DESC;
END //
DELIMITER ;

-- ORDENES RANGO DE FECHAS
DROP PROCEDURE IF EXISTS sp_ordenes_por_rango_fechas;
DELIMITER //
CREATE PROCEDURE sp_ordenes_por_rango_fechas(
IN p_inicio DATE,
IN p_fin DATE
)
BEGIN
SELECT *
FROM orden_laboratorio
WHERE DATE(fecha_orden) BETWEEN p_inicio AND p_fin
ORDER BY fecha_orden;
END //
DELIMITER ;

-- CAMBIAR ESTADO
DROP PROCEDURE IF EXISTS sp_cambiar_estado_orden;
DELIMITER //
CREATE PROCEDURE sp_cambiar_estado_orden(
IN p_id_orden INT,
IN p_estado VARCHAR(50)
)
BEGIN
UPDATE orden_laboratorio
SET estado = p_estado
WHERE id_orden = p_id_orden;
END //
DELIMITER ;

-- BUSCAR POR PACIENTE
DROP PROCEDURE IF EXISTS sp_buscar_orden_por_paciente;
DELIMITER //
CREATE PROCEDURE sp_buscar_orden_por_paciente(
IN p_id_paciente INT
)
BEGIN
SELECT *
FROM orden_laboratorio
WHERE id_paciente = p_id_paciente;
END //
DELIMITER ;

-- BUSCAR POR MEDICO
DROP PROCEDURE IF EXISTS sp_buscar_orden_por_medico;
DELIMITER //
CREATE PROCEDURE sp_buscar_orden_por_medico(
IN p_id_medico INT
)
BEGIN
SELECT *
FROM orden_laboratorio
WHERE id_medico = p_id_medico;
END //
DELIMITER ;

-- =====================================================
-- PROCEDIMIENTO: REGISTRAR RESULTADO
-- =====================================================
DELIMITER //
CREATE PROCEDURE sp_registrar_resultado (
    IN p_fecha DATETIME,
    IN p_descripcion TEXT,
    IN p_valores TEXT,
    IN p_conclusiones TEXT,
    IN p_id_orden INT,
    IN p_validado BOOLEAN
)
BEGIN
    INSERT INTO resultado_laboratorio
        (fecha_resultado, descripcion, valores_json, conclusiones, id_orden, validado)
    VALUES
        (p_fecha, p_descripcion, p_valores, p_conclusiones, p_id_orden, p_validado);
END //
DELIMITER ;

-- =====================================================
-- PROCEDIMIENTO: ACTUALIZAR RESULTADO
-- =====================================================
DELIMITER //
CREATE PROCEDURE sp_actualizar_resultado (
    IN p_id_resultado INT,
    IN p_fecha DATETIME,
    IN p_descripcion TEXT,
    IN p_valores TEXT,
    IN p_conclusiones TEXT,
    IN p_id_orden INT,
    IN p_validado BOOLEAN
)
BEGIN
    UPDATE resultado_laboratorio
    SET fecha_resultado = p_fecha,
        descripcion = p_descripcion,
        valores_json = p_valores,
        conclusiones = p_conclusiones,
        id_orden = p_id_orden,
        validado = p_validado
    WHERE id_resultado = p_id_resultado;
END //
DELIMITER ;

-- =====================================================
-- PROCEDIMIENTO: ELIMINAR RESULTADO
-- =====================================================
DELIMITER //
CREATE PROCEDURE sp_eliminar_resultado (
    IN p_id_resultado INT
)
BEGIN
    DELETE FROM resultado_laboratorio
    WHERE id_resultado = p_id_resultado;
END //
DELIMITER ;

-- =====================================================
-- PROCEDIMIENTO: BUSCAR RESULTADO
-- =====================================================
DELIMITER //
CREATE PROCEDURE sp_buscar_resultado (
    IN p_id_resultado INT
)
BEGIN
    SELECT *
    FROM resultado_laboratorio
    WHERE id_resultado = p_id_resultado;
END //
DELIMITER ;

-- =====================================================
-- PROCEDIMIENTO: LISTAR RESULTADOS
-- =====================================================
DELIMITER //
CREATE PROCEDURE sp_listar_resultados ()
BEGIN
    SELECT *
    FROM resultado_laboratorio
    ORDER BY id_resultado DESC;
END //
DELIMITER ;

-- =====================================================
-- PROCEDIMIENTO: VALIDAR RESULTADO
-- =====================================================
DELIMITER //
CREATE PROCEDURE sp_validar_resultado (
    IN p_id_resultado INT,
    IN p_validado BOOLEAN
)
BEGIN
    UPDATE resultado_laboratorio
    SET validado = p_validado
    WHERE id_resultado = p_id_resultado;
END //
DELIMITER ;
