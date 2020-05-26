package com.activeandroid.serializer;

import org.threeten.bp.LocalDate;

public final class LocalDateSerializer extends TypeSerializer {
	public Class<?> getDeserializedType() {
		return LocalDate.class;
	}

	public Class<?> getSerializedType() {
		return long.class;
	}

	public Long serialize(Object data) {
		if (data == null) {
			return null;
		}
		return ((LocalDate) data).toEpochDay();
	}

	public LocalDate deserialize(Object data) {
		if (data == null) {
			return null;
		}

		return LocalDate.ofEpochDay((Long) data);
	}
}
