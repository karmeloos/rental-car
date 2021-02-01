package Lists;

import Models.UserModel;

import java.util.LinkedList;
import java.util.List;

public class UserLists {
    private List<UserModel> activatedUsers = new LinkedList<>();
    private List<UserModel> deactivatedUsers = new LinkedList<>();

    public List<UserModel> getActivatedUsers() {
        return activatedUsers;
    }

    public List<UserModel> getDeactivatedUsers() {
        return deactivatedUsers;
    }
}
