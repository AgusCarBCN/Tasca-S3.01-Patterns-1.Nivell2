package factories;

import app.Nacionalidad;

public interface AbstractFactory<T> {

	T create(Nacionalidad tipo);
}
