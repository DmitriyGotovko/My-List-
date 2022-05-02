package com.example.myapplication

class MainController {
    private lateinit var view: MainView

    fun onViewReady(view: MainView) {
        this.view = view
        view.displayList(UserRepository.users)
    }

    fun onRemoveAllClicked() {
        UserRepository.removeAll()
        view.displayList(UserRepository.users)
    }

    fun onRemoveLastClicked() {
        UserRepository.removeLast()
        view.displayList(UserRepository.users)
    }

    fun onEditSecondClicked() {
        if (UserRepository.users.size < 2) return
        UserRepository.updateUser(1, User("Ivan ", "Ivanov", "Mexico"))
        view.displayList(UserRepository.users)
    }

    fun onAddRandomClicked() {
        UserRepository.addRandomUser()
        view.displayList(UserRepository.users)
    }
}