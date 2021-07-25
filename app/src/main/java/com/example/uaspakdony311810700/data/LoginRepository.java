package com.example.uaspakdony311810700.data;

import com.example.uaspakdony311810700.data.model.LoggedInUser;

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */
public class LoginRepository {

    private static volatile LoginRepository instance;

    private com.example.uaspakdony311810700.data.LoginDataSource dataSource;

    // If user credentials will be cached in local storage, it is recommended it be encrypted
    // @see https://developer.android.com/training/articles/keystore
    private LoggedInUser user = null;

    // private constructor : singleton access
    private LoginRepository(com.example.uaspakdony311810700.data.LoginDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static LoginRepository getInstance(com.example.uaspakdony311810700.data.LoginDataSource dataSource) {
        if (instance == null) {
            instance = new LoginRepository(dataSource);
        }
        return instance;
    }

    public boolean isLoggedIn() {
        return user != null;
    }

    public void logout() {
        user = null;
        dataSource.logout();
    }

    private void setLoggedInUser(LoggedInUser user) {
        this.user = user;
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }

    public com.example.uaspakdony311810700.data.Result<LoggedInUser> login(String username, String password) {
        // handle login
        com.example.uaspakdony311810700.data.Result<LoggedInUser> result = dataSource.login(username, password);
        if (result instanceof com.example.uaspakdony311810700.data.Result.Success) {
            setLoggedInUser(((com.example.uaspakdony311810700.data.Result.Success<LoggedInUser>) result).getData());
        }
        return result;
    }
}