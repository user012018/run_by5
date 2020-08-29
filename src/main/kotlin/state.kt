class Order(private var currentState: State) {

    fun changeState(state: State) {
        currentState = state
    }

    fun handleInput(inputType: InputType) {
        try {
            currentState.handleInput(this, inputType)
        } catch (e: OrderException) {
            println(e.msg)
        }
    }

}

class AssignedState : State {

    override fun handleInput(order: Order,
                             inputType: InputType) {
        when (inputType) {
            InputType.PressStartWorkButton -> {
                println("Заявка в работе")
                order.changeState(InProgressState())
            }
            InputType.PressAddPhotoButton -> {
                throw OrderException("Пока нельзя добавить фотографию к заявке")
            }
            InputType.PressEndWorkButton -> {
                println("Заявка закрыта")
                order.changeState(ServicedState())
            }
            InputType.PressPostponeButton -> {
                println("Заявка отложена")
                order.changeState(PostponedState())
            }
        }
    }
}

class InProgressState : State {

    override fun handleInput(order: Order,
                             inputType: InputType) {
        when (inputType) {
            InputType.PressStartWorkButton -> {
                throw OrderException("Заяка уже в работе")
            }
            InputType.PressAddPhotoButton -> {
                println("Добавлена фотография в заявку")
            }
            InputType.PressEndWorkButton -> {
                println("Заявка закрыта")
                order.changeState(ServicedState())
            }
            InputType.PressPostponeButton -> {
                println("Заявка отложена")
                order.changeState(PostponedState())
            }
        }
    }
}

class PostponedState : State {

    override fun handleInput(order: Order, inputType: InputType) {
        when (inputType) {
            InputType.PressStartWorkButton -> {
                println("Заявка в работе")
                order.changeState(InProgressState())
            }
            InputType.PressAddPhotoButton -> {
                throw OrderException("Пока нельзя добавить фотографию к заявке")
            }
            InputType.PressEndWorkButton -> {
                println("Заявка закрыта")
                order.changeState(ServicedState())
            }
            InputType.PressPostponeButton -> {
                throw OrderException("Заяка уже отложена")
            }
        }
    }

}

class ServicedState : State {

    override fun handleInput(order: Order, inputType: InputType) {
        throw OrderException("Заяка уже закрыта")
    }

}

interface State {

    fun handleInput(order: Order, inputType: InputType)

}

private class OrderException(val msg: String) : RuntimeException()

sealed class InputType {
    object PressStartWorkButton : InputType()
    object PressEndWorkButton : InputType()
    object PressPostponeButton : InputType()
    object PressAddPhotoButton : InputType()
}
