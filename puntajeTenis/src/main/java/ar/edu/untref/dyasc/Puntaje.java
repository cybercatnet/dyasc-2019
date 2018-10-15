package ar.edu.untref.dyasc;

public interface Puntaje<TipoValores> {

    public TipoValores agregarPunto();

    public TipoValores quitarPunto();

    public void setPuntaje(TipoValores valor);

    public TipoValores getPuntaje();

}
