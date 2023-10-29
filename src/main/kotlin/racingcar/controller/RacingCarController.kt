package racingcar.controller

import racingcar.model.CarInitializer
import racingcar.model.RacingCarGame
import racingcar.strategy.MovingStrategy
import racingcar.strategy.RandomNumberMovingStrategy
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingCarController() {
    fun startGame() {
        val strategy: MovingStrategy = RandomNumberMovingStrategy()
        val numbersOfCar = InputView.getNumbersOfCars()
        val numbersOfTry = InputView.getNumbersOfTry()
        val cars = CarInitializer.createCars(numbersOfCar)
        val game = RacingCarGame(cars, strategy)
        ResultView.printInitial()
        for (i in 1..numbersOfTry) {
            game.run()
            ResultView.printResult(game.cars)
            ResultView.printEmptyLine()
        }
    }
}