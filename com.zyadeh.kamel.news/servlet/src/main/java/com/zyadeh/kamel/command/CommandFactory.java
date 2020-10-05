package com.zyadeh.kamel.command;

import com.zyadeh.kamel.command.impl.*;
import com.zyadeh.kamel.service.impl.NewsService;
import com.zyadeh.kamel.service.impl.UserService;
//
//public class CommandFactory {
//
//    public static Command getCommand(String commandType) {
//
//        switch (commandType) {
//            case "command_register":
//                return new RegisterUserCommand(new UserService());
//            case "command_login":
//                return new LoginUserCommand(new UserService());
//            case "command_fetch":
//                return new FetchNewsCommand(new NewsService());
//            case "news_update_command":
//                return new NewsUpdateCommand(new NewsService());
//            case "create_news_command":
//                return new CreateNewsCommand(new NewsService());
//            case "update_user_command":
//                return new UserUpdateCommand();
//            case "search_news_command":
//                return new SearchNewsCommand(new NewsService());
//            case "selected_news":
//                return new SelectedNewsCommand();
//           case "news_print_command":
//                return new PrintNewsFromListCommand(new NewsService());
//            default:
//                return new HomeCommand();
//        }
//    }
//}
