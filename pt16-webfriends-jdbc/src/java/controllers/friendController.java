/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.Friend;
import model.persist.CategoryDAO;
import model.persist.FriendDAO;

@WebServlet(name = "friendController", urlPatterns = {"/friendController"})
public class friendController extends HttpServlet {

    private FriendDAO friendAdo;
    private CategoryDAO categoryAdo;
    // private CategoryDAO categoryAdo;
    private String ruta;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doAction(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        String action = request.getParameter("actionFriend");
        ruta = getServletContext().getRealPath("/WEB-INF/resources");

        if (action != null) {
            switch (action) {
                case "List all Friends":
                    listAll(request, response);
                    break;
                case "New Friend":
                    response.sendRedirect("friend.jsp?showFormAdd=1");
                    break;
                case "Add Friend":
                    insertFriend(request, response);
                    break;
                case "Delete a Friend":
                    response.sendRedirect("friend.jsp?showFormDelete=1");
                    break;
                case "deleteFriend":
                    deleteFriend(request, response);
                    break;
//                case "Modify a Friend":
//                    response.sendRedirect("friend.jsp?choseToModify=1");
//                    break;
//                case "modifyFriend":
//                    modifyFriendForm(request, response);
//                    break;
//                case "modify":
//                    modify(request, response);
//                    break;
                // 1 - Load the friends list with the Edit button in each row.
                case "loadFriendsListToModify":
                    loadFriendsListToModify(request, response);
                    break;
                // 2 - Select the category to edit and load the category data
                // in a form.
                case "loadFriendFormToModify":
                    loadFriendFormToModify(request, response);
                    break;
                // 3 - Finally, the user press the submit button with the new data.
                // This operation updates the category data in database.  
                case "updateFriend":
                    updateFriend(request, response);
                    break;
                default:
                    response.sendRedirect("index.jsp");
            }

        } else {
            response.sendRedirect("index.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            doAction(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(friendController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            doAction(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(friendController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void listAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {

        friendAdo = new FriendDAO(ruta);
        ArrayList<Friend> friends = friendAdo.findAll();
        request.setAttribute("friends", friends);
        RequestDispatcher dispatcher = request.getRequestDispatcher("friend.jsp");
        dispatcher.forward(request, response);
    }

    private void insertFriend(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO
        if (request.getParameter("friendName") != null) {
            String friendPhone = request.getParameter("friendPhone");
            String friendName = request.getParameter("friendName");
            String fAge = request.getParameter("friendAge");
            int friendAge = Integer.parseInt(fAge);
            String fCatId = request.getParameter("friendCategoryId");
            int friendCategoryId = Integer.parseInt(fCatId);

            friendAdo = new FriendDAO(ruta);
            Friend newFriend = new Friend(friendPhone,friendName,friendAge,friendCategoryId);

            if (friendAdo.insert(newFriend) == 1) {
                request.setAttribute("success", "Friend " + friendName + "Successfully inserted :) !");
            } else {
                request.setAttribute("error", "Friend not inserted :( !");
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("friend.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("friend.jsp");
        }

    }

    private void deleteFriend(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO
    }

    private void loadFriendsListToModify(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        friendAdo = new FriendDAO(ruta);
        ArrayList<Friend> friends = friendAdo.findAll();
        request.setAttribute("friends", friends);
        RequestDispatcher dispatcher = request.getRequestDispatcher("friend.jsp");
        dispatcher.forward(request, response);
    }

    private void loadFriendFormToModify(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // A partir de la PK de Friend vamos a consultar los demás datos de Friend.
        String friendID = request.getParameter("friend");
        int friendPK = friendID!=null?Integer.parseInt(friendID):0;
        
        Friend friend = friendAdo.findOne(friendPK);
        request.setAttribute("friendmodify", friend);
        
        // TODO.
        // Opcional: Cargar la lista de categorias 
        // para que las ponga en un campo select.
        // List<Category> categoriesList = categoryAdo.findAll();
        // request.setAttribute("categoriesListModify", friend);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("friend.jsp");
        dispatcher.forward(request, response);
    }
    
    private void updateFriend(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Friend newFriend = null;
        // Paso 31. Recoger datos del form.
        if (request.getParameter("friendName") != null) {
            String friendPhone = request.getParameter("friendPhone");
            String friendName = request.getParameter("friendName");
            String fAge = request.getParameter("friendAge");
            int friendAge = Integer.parseInt(fAge);
            // Aquests no és necessari editar-los.
            String fCatId = request.getParameter("friendCategoryId");
            int categoryId = Integer.parseInt(fCatId);
            // String fCatDesc = request.getParameter("friendCategoryDesc");
            String fId = request.getParameter("id_friends");
            int friendId = Integer.parseInt(fId);
       
            // Paso 32. Crear el objeto Friend con estos datos.
            // int idFriend, String phone, String name, int age, int categoryId
            newFriend = 
                new Friend(friendId,friendPhone,
                    friendName,friendAge,categoryId);
        }
        
        // Paso 33. Realizar el update en la BBDD.
        friendAdo = new FriendDAO(ruta);
        int rowsAffected = friendAdo.update(newFriend);
        // Paso 34. Informar al usuario como ha ido el udpate.
        if (rowsAffected > 0) {
            request.setAttribute("success", "Friend " 
                    + newFriend.getName() + " Successfully modified :) !");
        } else {
            request.setAttribute("error", "Friend not updated :( !");
        }
          
        // Paso 35. volver a la jsp.
        RequestDispatcher dispatcher = request.getRequestDispatcher("friend.jsp");
        dispatcher.forward(request, response);
    }

}
