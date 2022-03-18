package com.jessmorse.travelblog.user;

import com.jessmorse.travelblog.comment.CommentDAO;
import com.jessmorse.travelblog.exceptions.ResourceNotFound;
import com.jessmorse.travelblog.post.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {

    private UserDAO userDAO;
    private CommentDAO commentDAO;
    private PostDAO postDAO;

    //@Autowired
    public UserService(@Qualifier("User") UserDAO userDAO,
                       @Qualifier("comment") CommentDAO commentDAO, @Qualifier("Post") PostDAO postDAO){
        this.userDAO = userDAO;
        this.commentDAO = commentDAO;
        this.postDAO = postDAO;
    }

    public void addUserToDatabase(User user){

        //check email is valid
//        if(user.getEmail()==null) {
//            throw new ResourceNotFound("Please provide email address");
//        }
//        String email = user.getEmail();
//        boolean b = isValidEmail(email);
//        if(b==false){
//            throw new ResourceNotFound("Email address not valid");
//        }else if {

            userDAO.addUserToDatabase(user);
        //}
    }


    public void removeUserFromDatabase(long id) {
        if (userDAO.getUserById(id).isEmpty()){
            throw new ResourceNotFound("User with this id does not exist");
        }
        userDAO.removeUserFromDatabase(id);
        //commentDAO.deleteCommentByUser(id);
        //postDAO.deletePostByUser(id);
    }


    public Optional<User> getUserById(long id) {
        if (userDAO.getUserById(id).isEmpty()) {
            throw new ResourceNotFound("User with this id not found :/");
        };
        return userDAO.getUserById(id);
    }


    public void updateUser(long id, User user) {
        if (userDAO.getUserById(id).isEmpty()) {
            throw new ResourceNotFound("User with this id not found :/");
        };

        userDAO.updateUser(id, user);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    };


    //function to check if email is valid
//    public static boolean isValidEmail(String email) {
//        //regex to check email format.
//        String regex = "^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$";
//        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
//
//        //if email null return false
//        if (email == null) {
//            return false;
//        }
//
//        //matcher() finds matching between email and regex
//        Matcher m = p.matcher(email);
//        return m.matches();
//    }
//"^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$"
}

