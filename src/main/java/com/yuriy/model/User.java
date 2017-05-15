package com.yuriy.model;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;

/**
 * Created by yyakymchuk on 5/7/2017.
 */
@JsonSerialize
public class User implements Serializable{

	private static final long serialVersionUID = -5127534012509483833L;

	private Long id;

	@NotBlank(message = "Name can't be empty")
	private String name;

	@NotBlank(message = "Surname can't be empty")
	private String surname;

	public User(final Long id, final String name, final String surname) {

		Preconditions.checkArgument(id != null);
		Preconditions.checkArgument(StringUtils.isNoneEmpty(name));
		Preconditions.checkArgument(StringUtils.isNoneEmpty(surname));

		this.id = id;
		this.name = name;
		this.surname = surname;
	}

	public User withId(final Long id) {
		Preconditions.checkArgument(id != null);

		return new User(id, name, surname);
	}

	public User withName(final String name) {
		Preconditions.checkArgument(StringUtils.isNoneEmpty(name));

		return new User(id, name, surname);
	}

	public User withSurname(final String surname) {
		Preconditions.checkArgument(StringUtils.isNoneEmpty(surname));

		return new User(id, name, surname);
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}

		if (!(o instanceof User)) {
			return false;
		}

		final User user = (User) o;

		return new EqualsBuilder()
			.append(getId(), user.getId())
			.append(getName(), user.getName())
			.append(getSurname(), user.getSurname())
			.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
			.append(getId())
			.append(getName())
			.append(getSurname())
			.toHashCode();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
