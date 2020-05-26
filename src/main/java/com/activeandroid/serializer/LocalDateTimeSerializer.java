package com.activeandroid.serializer;

import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;

public final class LocalDateTimeSerializer extends TypeSerializer {
	public Class<?> getDeserializedType() {
		return LocalDateTime.class;
	}

	public Class<?> getSerializedType() {
		return long.class;
	}

	public Long serialize(Object data) {
		if (data == null) {
			return null;
		}
		return ((LocalDateTime) data).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
	}

	public LocalDateTime deserialize(Object data) {
		if (data == null) {
			return null;
		}

		return LocalDateTime.ofInstant(Instant.ofEpochMilli((Long) data), ZoneId.systemDefault());
	}
}
