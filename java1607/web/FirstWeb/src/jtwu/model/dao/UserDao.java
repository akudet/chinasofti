package jtwu.model.dao;

// i kind of understand how this may use(seems good usage for me
// I try to think dao as a way to represent the User mode in database
// so the User model may be a subset, or so projection of the actual
// representation
// actually there got two way of using it, first the customer use the
// User class to talk to database, not the UserDAO e.g.
// we can provide the save, create in the user class,
// the other way is the customer(programmer) use UserDAO class and
// User class, this is the I state at previous, which is the user
// use the DAO to get a projection of actual representation, and use
// User class to wrap the result, em. use DAO to get a User object.
public class UserDao {

}
