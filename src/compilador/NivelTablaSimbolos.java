/*
 * Created on 30-may-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package compilador;

import java.util.HashMap;

/**
 * @author txetxu
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class NivelTablaSimbolos {

	private int nivel;
	private NivelTablaSimbolos nivelAnt = null;
//	private NivelTablaSimbolos nivelSig = null;
	private boolean activo = false;
	private HashMap tabla = null;
	private int direccion = 0;
	private int tamEspacio = 0;
	private int tamEspacioLocal = 0;
	
	public NivelTablaSimbolos(NivelTablaSimbolos anterior, int nivel){
		this.nivel = nivel;
		nivelAnt = anterior;
		tabla = new HashMap();
	}
	
	public void setTamEspacio(int valor){
		this.tamEspacio=valor;
	}

	public int getTamEspacio(){
		return tamEspacio;
	}
	
	public void setTamEspacioLocal(int valor){
		this.tamEspacioLocal=valor;
	}

	public int getTamEspacioLocal(){
		return tamEspacioLocal;
	}
	
/*	public NivelTablaSimbolos nuevoNivel(){
		nivelSig = new NivelTablaSimbolos(this, nivel + 1);
		return nivelSig;
	} */
	
/*	private boolean existe(String nombre){
		return tabla.containsKey(nombre);
	} */
	
	/**
	 * @return Returns the activo.
	 */
/*	public boolean isActivo() {
		return activo;
	} */
	
	/**
	 * @param activo The activo to set.
	 */
/*	public void setActivo(boolean act) {
		activo = act;
	} */
	
	/**
	 * @return Returns the nivel.
	 */
	public int getNivel() {
		return nivel;
	}
	
	/**
	 * @param n The nivel to set.
	 */
	public void setNivel(int n) {
		nivel = n;
	}

	/**
	 * @return Returns the nivelAnt.
	 */
	public NivelTablaSimbolos getNivelAnt() {
		return nivelAnt;
	}
	
	/**
	 * @param nivelAnt The nivelAnt to set.
	 */
	public void setNivelAnt(NivelTablaSimbolos anterior) {
		nivelAnt = anterior;
	}
	
	/**
	 * @return Returns the nivelSig.
	 */
/*	public NivelTablaSimbolos getNivelSig() {
		return nivelSig;
	} */
	
	/**
	 * @param nivelSig The nivelSig to set.
	 */
/*	public void setNivelSig(NivelTablaSimbolos siguiente) {
		nivelSig = siguiente;
	} */
	
	/**
	 * @return Returns the tabla.
	 */
/*	public HashMap getTabla() {
		return tabla;
	} */
	
	/**
	 * @param tabla The tabla to set.
	 */
/* public void setTabla(HashMap tabla) {
		this.tabla = tabla;
	} */
	
	public Objeto getObjeto(String nombre){
/* Devuelve null si la clave tiene un objeto null asociado
 * o si la clave no existe en la tabla
 * Como hemos limitado la inserción de nulos this.insertaObjeto 
 * sólo puede ser la segunda opción */ 
		return (Objeto) tabla.get(nombre);
	}
	
	public void insertaObjeto(String nombre, Object objeto) throws NullPointerException, ObjetoExisteException{
		if (objeto == null || nombre == null){
			throw new NullPointerException("El nombre y el objeto deben existir");
		}
		else{
			if (tabla.containsKey(nombre)){
				throw new ObjetoExisteException();
			}
			else
				tabla.put(nombre, objeto);//quitar si limitamos los null en la tabla
		} 
	}
	
	public int getDireccion(){
		return direccion;
	}
	
	public void setDireccion(int direccion){
		this.direccion=direccion;
	}
}
