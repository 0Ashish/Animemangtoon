package com.example.animemangtoon.model


import android.os.Parcel
import android.os.Parcelable

data class Webtoon(
    val title: String,
    val imageUrl: String,
    val description: String
) : Parcelable {
    // Constructor for Parcel
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    // Write object properties to the Parcel
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(imageUrl)
        parcel.writeString(description)
    }

    // This is required for the Parcelable interface, usually returns 0
    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Webtoon> {
        override fun createFromParcel(parcel: Parcel): Webtoon {
            return Webtoon(parcel)
        }

        override fun newArray(size: Int): Array<Webtoon?> {
            return arrayOfNulls(size)
        }
    }
}

val webToonList = listOf(
    Webtoon("1. Solo Leveling",
        "https://animemangatoon.com/wp-content/uploads/2024/06/Screenshot-2024-10-01-090334-750x375.webp",
        "One of the best action fantasy manhwa and the most talked about adaptation in recent times is undoubtedly Solo Leveling. It is set in a world where humans have discovered supernatural skills, while our protagonist, Sung Jin-Woo, is a nobody with his E-Rank hunting skills. Things will take an interesting turn for him when he becomes the sole survivor of a dungeon raid. Awakened with strange new powers, Sung Jin-Woo will level up from being the weakest Hunter and eventually become the most powerful entity in the universe."

    ),
    Webtoon("2. Tower of God",
        "https://animemangatoon.com/wp-content/uploads/2024/06/tower-of-god.webp",
        "Even if you are not a manhwa fan, you must have heard of Tower of God. This action fantasy manhwa became especially popular after its anime adaptation. Tower of God focuses on Twenty-Fifth Bam, the young protagonist of the manhwa, who is determined to climb a mysterious Tower to find his friend Rachel. It is to be noted that the titular tower has different floors, and each floor has different obstacles. His quest is not going to be an easy one, and whether or not he will be able to meet his friend remains to be seen. Tower of God Season 2 has also been recently released."
    ),
    Webtoon("3. Hardcore Leveling Warrior",
        "https://animemangatoon.com/wp-content/uploads/2024/06/hard-levelign-warrior-750x375.webp",
        "Gong Won-Ho is the top player of Lucid Adventure because he uses his alias, Hardcore Leveling Warrior, to stay on top. However, one day, the unimaginable happens – he gets defeated, and now he has to get back on the top from the bottom. The most fascinating aspect of this action fantasy manhwa is how he climbed his way to the top in the first place."
    ),
    Webtoon("4. Noblesse",
        "https://animemangatoon.com/wp-content/uploads/2024/06/noblesse-750x375.webp",
        "After being in a slumber for over 800 years, Cadis Etrama Di Raizel, aka Rai, wakes up in an unfamiliar modern world. Fortunately, he meets his loyal servant Frankenstein, who is now the owner of a high school. After attending the school, Rai tries to live an ordinary life, concealing his true identity; however, that won’t happen for long. This supernatural action fantasy manhwa will keep you engaged with its beautiful illustration and unique narrative till the end. It also has its anime adaptation."
    ),
    Webtoon("5. The God of High School ",
        "https://animemangatoon.com/wp-content/uploads/2024/06/Screenshot-2024-10-01-000548-750x375.webp",
        "The God of High School is one of the best action fantasy manhwa that has been adapted into an anime. Jin Mori, the protagonist of the story, takes part in a suspicious tournament, the prize of which is whatever the winner wants. Like Twenty-Fifth Baam, Mori seems like an ordinary individual, but as he confronts challenges, he understands more about the three realms and his powers."
    ),
    Webtoon("6. Second Life Ranker",
        "https://animemangatoon.com/wp-content/uploads/2024/06/Second-life-ranker-750x375.webp",
        "Second Life Ranker tells the story of Yeon-Woo who is searching for his twin brother. He stumbles upon hints that lead to the certainty of his brother’s demise in an alternate dimension. Yeon-Woo is determined to find the people behind his brother’s death and eventually embarks on his journey of revenge and along the way he unravels the mysterious Tower of the Sun God."

    ),
    Webtoon("7. Eleceed",
        "https://animemangatoon.com/wp-content/uploads/2024/06/elecceed-750x375.webp",
        "How would you feel if one day you got superpowers or if you were just born with it? Would you use it to help others or to rule over the weak ones? The Eleceed webtoon focuses on the protagonist, Jiwoo. He is a young man with super speed, although he thinks he is a monster because of his power. One day, he finds an injured fat cat passed in an alley with blood splattered over it. He brings the cat home and learns it is a human in cat form – his name is Kayden, an awakened being with supernatural powers. Kayden helps Jiwoo learn how to defend himself against his opponents."
    ),
    Webtoon("8. The Advanced Player of the Tutorial Tower",
        "https://animemangatoon.com/wp-content/uploads/2024/06/Advanced-Player-750x375.webp",
        "Several monsters have evaded the earth and they began the ultimate destructions. Suddenly, a long tower called the tutorial tower came into existence, and no one knew if it was a structure or a monster. People from all over started being teleported inside that tower and had to fight monsters to survive. Only 20% of those people would make it out alive and were called ‘Hunters.’ They were given special powers to fight the monsters. Unfortunately, Hyeonu Kim was one of the first people to end up there but could not leave that place even after killing all the monsters. Instead, he would end up on the first level again and was trapped there for 12 years. "
    ),
    Webtoon("9. Leveling Up With The Gods",
        "https://animemangatoon.com/wp-content/uploads/2024/06/leveling-up-with-the-gods-750x375.webp",
        "Kim Yuwon has witnessed the destruction of gods and humans at the hands of The Tower. At the brink of death and having lost everything, Kim is given another opportunity through the sacrifice of his companions and return to the past. Now that he has more experience, he is determined to climb the Tower again and change everything within The Tower."
    ),
    Webtoon("10. Villain to Kill",
        "https://animemangatoon.com/wp-content/uploads/2024/06/Villain-to-kill-750x375.webp",
        "Cassian Lee is a Pysker, a very powerful one at that. Psykers are people with inhumane abilities, and they use them to fight evil and protect the weak. While. Villians are the ones just as strong, but they use their ability to make people miserable. When Cassion’s only guardian, Jeff, died in front of him, he lost all hope. All he wanted was revenge, but he died helplessly. However, he woke up in the body of a villain because of the necklace Jeff gave him. What will he do now? Will he give in to his villain instincts or fight the evils instead? Read to the Villain to Kill webtoon to know more. "
    ),
    Webtoon("11. Action Fantasy Manhwa: Hero Killer",
        "https://animemangatoon.com/wp-content/uploads/2024/06/hero-killer-750x375.webp",
        "What would happen to the world if the heroes and villains all acted the same? They all want to exert their powers on the ones weaker than them. They all do not care about the safety of those weaker than them. Ihwa is a young beautiful girl who had a traumatic past, her only family, her sister, died at the hands of the ones who were supposed to protect all. What will happen when she sets out to fulfill her revenge? Who are those people helping her? What are their motives? Read the Hero Killer webtoon to know more. "
    ),
    Webtoon("12. Return to Player",
        "https://animemangatoon.com/wp-content/uploads/2024/06/return-to-player-750x375.webp",
        "Typical dark fantasy manhwa, Return To Player, is popular for its rich storyline and mythic constellation lore, which offers the reader an exciting experience. It is set in a fantasy clone of Earth, where gods have turned humans into players of a terrifying game of life and death. Sehan Kim has once witnessed the sadistic conclusion of this game, where everyone but him dies. Given a second opportunity, he is back in the time when everything began."
    ),
    Webtoon(" 13. Jungle Juice",
        "https://animemangatoon.com/wp-content/uploads/2024/06/junglee-juice-750x375.webp",
        "Suchan Jang is a brilliant student; however, beneath the perfection, he is concealing insect wings that abruptly grow when he uses the titular bug spray. Suchan’s life changes when he exposes his wings to everyone’s view to save somebody’s life. When he feels lost in the real world, he stumbles upon a concealed world of insect humans where there is no judgment. However, a jungle law controls this society, and everyone must fend for themselves to survive."
    ),
    Webtoon("14 Lore Olympus",
        "https://animemangatoon.com/wp-content/uploads/2024/06/lore-olympus-750x375.webp",
        "We can’t talk about the best fantasy manhwa and not mention Lore Olympus. Have you ever read Greek Mythology? Do you find it interesting? Well, a lot of people certainly do. However, the storyline and the order of events can be a little too difficult for most people to remember or even understand. ‘Lore Olympus’ is such a webtoon based on Greek mythology, with an easy-to-understand plot that uses modern-day events and lifestyle. The plot is primarily based on Hades and Persephone’s love story. Moreover, it also covers the lifestyle of all the gods surrounding them and the events of great importance."
    ),
    Webtoon("15 The Remarried Empress",
        "https://animemangatoon.com/wp-content/uploads/2024/06/Remarried-Empress-750x375.webp",
        "Navier, the empress of the Eastern Empire, was shattered in front of her when her husband Sovieshu, Emperor of the Eastern Empire, wanted to divorce her because she couldn’t give him an heir. He cast her aside when she couldn’t bear him a child, even though they groomed her to become the perfect empress ever since her childhood. Read The Remarried Empress to find out more about her struggles and dilemmas when an unexpected variable appeared in her life."
    ),
    Webtoon("16 Leveling Up My Husband to the Max",
        "https://animemangatoon.com/wp-content/uploads/2024/06/Leveling-up-my-husband-to-the-max-750x375.webp",
        "The central character of Leveling Up My Husband to the Max, Amber, is in turmoil with her controlling mother-in-law and cruel husband. Following the time-travel theme, Amber is sent back 10 years into the past, and she confronts her husband, who now adores her. With her knowledge of the potential future, she tries to change her husband, navigate the complexities of the past, and create a new narrative for herself."
    ),
    Webtoon("17 I’m the Queen in this Life",
        "https://animemangatoon.com/wp-content/uploads/2024/06/Im-the-queen-in-this-life-750x375.webp",
        "Ariadne is the illegitimate daughter of a nobleman who is married to the king’s illegitimate son. Her husband Cesare conspires with her to kill his half-brother, the crown prince, to take over the throne for himself. Their plan is successful, but Ariadne’s life turns upside down when she finds her husband to betray her and marries her half-sister instead. What is more, her sister is the one who put the dagger in her heart. Ultimately, she vows to take revenge, and the heavens listen to her. She is sent back in time when she was 17 years old."
    ),
    Webtoon("18 The Witch and the Bull",
        "https://animemangatoon.com/wp-content/uploads/2024/06/the-witch-and-the-bull-750x375.webp",
        "Deo is trying to live a peaceful life, but his friend and advisor, Tan, denies this. Tan believes that if they show any signs of weakness, the witches will try to control them. When Tan goes to a popular cafe and learns that it is run by a beautiful witch named Aro, he uses his power to shut it down, and this changes his fate. And the only way to undo this curse is to rely on Aro. Can Aro’s kindness change Tan and finally break this spell?"
    ),
    Webtoon("19 From A Knight to A Lady",
        "https://animemangatoon.com/wp-content/uploads/2024/06/from-a-knight-to-a-lady-750x375.webp",
        "Estelle is a young knight in the Kingdom of Ersha who fought with immense strength until her last breath for her country. Sadly, her most trusted comrade kills her. Miraculously, 3 years later, she finds herself reincarnated as Lucifella, the rumored partner of the crown prince of Jansgar, the enemy kingdom. What’s more? She is now the betrothed of Duke Heint, her mortal enemy from her last life."
    ),
    Webtoon("20 For My Derelict Favorite",
        "https://animemangatoon.com/wp-content/uploads/2024/06/for-my-derelict-750x375.webp",
        "Hestia enters the fictional world of her favorite novel as a secondary character. She believes she will transfer to the real world once the story ends. However, she finds that the only thing awaiting her is the horrifying death of Hestia’s favorite character. Hestia decides not to be a viewer from the sidelines anymore. She is determined to save her derelict favorite. Read For My Derelict Favorite to know what happens after “happily ever after?”"
    ),

    )
