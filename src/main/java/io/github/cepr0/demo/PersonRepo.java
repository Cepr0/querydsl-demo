package io.github.cepr0.demo;

import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

/**
 * @author Sergei Poznanski, 2018-04-20
 */
public interface PersonRepo extends JpaRepository<Person, Integer>, QuerydslPredicateExecutor<Person>, QuerydslBinderCustomizer<QPerson> {
	
	@Override
	default void customize(QuerydslBindings bindings, QPerson person) {
		bindings.excluding(person.id);
		bindings.bind(person.name).first(StringExpression::containsIgnoreCase);
	}
}
