package ru.marslab.ruen.typicalsituations.model

import ru.marslab.ruen.R

fun getSituationsData(): List<Situations> {
    return listOf(
        Situations(
            R.drawable.taxi,
            "Taxi",
            "Вы не знаете, где можно поймать такси?",
            "Do you know where I can get a taxi?",
            "Не могли бы вы отвезти меня в центр города?",
            "Could you take me to the city centre?"
        ),
        Situations(
            R.drawable.airport,
            "Airport",
            "Сколько времени продлится полет?",
            "How long does the flight take?",
            "Мне нечего декларировать.",
            "I have nothing to declare."
        ),
        Situations(
            R.drawable.shop,
            "Shop",
            "Вы принимаете кредитные карточки?",
            "Do you take credit cards?",
            "Могу я купить это без налога?",
            "Can I buy it tax-free?"
        ),
        Situations(
            R.drawable.direction,
            "Direction",
            "Вы не подскажете, как добраться до…?",
            "Could you tell me how to get to the ...?",
            "Вы можете показать мне на карте?",
            "Can you show me on the map?"
        )
    )
}