package ru.marslab.ruen.typicalsituations.model

fun getSituationsData(): List<Situations> {
    return listOf(
        Situations(
            "https://cdn.pixabay.com/photo/2015/10/14/20/02/taxi-988348_960_720.jpg",
            "Taxi",
            "Вы не знаете, где можно поймать такси?",
            "Do you know where I can get a taxi?",
            "Не могли бы вы отвезти меня в центр города?",
            "Could you take me to the city centre?"
        ),
        Situations(
            "https://cdn.pixabay.com/photo/2020/07/09/14/10/airport-5387490_960_720.jpg",
            "Airport",
            "Сколько времени продлится полет?",
            "How long does the flight take?",
            "Мне нечего декларировать.",
            "I have nothing to declare."
        ),
        Situations(
            "https://cdn.pixabay.com/photo/2016/11/22/21/57/apparel-1850804_960_720.jpg",
            "Shop",
            "Вы принимаете кредитные карточки?",
            "Do you take credit cards?",
            "Могу я купить это без налога?",
            "Can I buy it tax-free?"
        ),
        Situations(
            "https://cdn.pixabay.com/photo/2021/09/09/04/24/signpost-6609445_960_720.jpg",
            "Direction",
            "Вы не подскажете, как добраться до…?",
            "Could you tell me how to get to the ...?",
            "Вы можете показать мне на карте?",
            "Can you show me on the map?"
        ),
        Situations(
            "https://cdn.pixabay.com/photo/2017/08/02/18/14/architecture-2572715_960_720.jpg",
            "Hotel",
            "Я бы хотел забронировать номер.",
            "I'd like to book a room.",
            "Я потерял ключ от номера.",
            "I've lost my room key."
        ),
        Situations(
            "https://cdn.pixabay.com/photo/2015/05/31/11/23/table-791167_960_720.jpg",
            "Restaurant",
            "Я бы хотел заказать столик.",
            "I want to order a table.",
            "Я бы хотел бокал вина.",
            "I'd like a glass of wine."
        ),
        Situations(
            "https://cdn.pixabay.com/photo/2019/09/30/18/11/flight-4516478_960_720.jpg",
            "Airplane",
            "Могу я поменяться с вами местами?",
            "Could I change seats with you?",
            "Можно мне откинуть спинку сидения?",
            "May I recline my seat?"
        ),
        Situations(
            "https://cdn.pixabay.com/photo/2017/11/01/11/34/bank-2907728_960_720.jpg",
            "Bank",
            "Каков обменный курс валют долларов в фунты?",
            "What’s the exchange rate for dollars to pounds?",
            "Я бы хотел обменять свои деньги.",
            "I would like to change my money."
        )
    )
}