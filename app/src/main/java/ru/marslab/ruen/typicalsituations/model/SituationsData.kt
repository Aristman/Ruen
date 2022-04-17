package ru.marslab.ruen.typicalsituations.model

import ru.marslab.ruen.R

fun getSituationsData(): List<Situations> {
    return listOf(
        Situations(
            R.drawable.taxicity,
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
        ),
        Situations(
            R.drawable.hotel,
            "Hotel",
            "Я бы хотел забронировать номер.",
            "I'd like to book a room.",
            "Я потерял ключ от номера.",
            "I've lost my room key."
        ),
        Situations(
            R.drawable.restaurant,
            "Restaurant",
            "Я бы хотел заказать столик.",
            "I want to order a table.",
            "Я бы хотел бокал вина.",
            "I'd like a glass of wine."
        ),
        Situations(
            R.drawable.airplane,
            "Airplane",
            "Могу я поменяться с вами местами?",
            "Could I change seats with you?",
            "Можно мне откинуть спинку сидения?",
            "May I recline my seat?"
        ),
        Situations(
            R.drawable.bank,
            "Bank",
            "Каков обменный курс валют долларов в фунты?",
            "What’s the exchange rate for dollars to pounds?",
            "Я бы хотел обменять свои деньги.",
            "I would like to change my money."
        )
    )
}
