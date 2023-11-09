package com.rabilu.ngnews.domain.model

data class News(
    val id: String,
    val headline: String,
    val description: String,
    val imageUrl: String,
)

val newsList = listOf(
    News(
        "1",
        headline = "Business Insider",
        description = "Business Insider is a fast-growing business site with deep financial, media, tech, and other industry verticals. Launched in 2007, the site is now the largest business news site on the web.",
        imageUrl = ""
    ),
    News(
        "1",
        headline = "Bloomberg",
        description = "Bloomberg delivers business and markets news, data, analysis, and video to the world, featuring stories from Businessweek and Bloomberg News.",
        imageUrl = ""
    ),
    News(
        "1",
        headline = "Blasting News (BR)",
        description = "Descubra a seção brasileira da Blasting News, a primeira revista feita pelo  público, com notícias globais e vídeos independentes. Junte-se a nós e torne- se um repórter.",
        imageUrl = ""
    ),
    News(
        "1",
        headline = "Axios",
        description = "Axios are a new media company delivering vital, trustworthy news and analysis in the most efficient, illuminating and shareable ways possible.",
        imageUrl = ""
    ),
    News(
        "1",
        headline = "Mohbad: Naira Marley relseases last coversation with late singer, police arrest Sam Larry",
        description = "Lorem ipsum dolor sit amet consectetur. Sodales nibh quam pulvinar nunc augue diam. Dui vel faucibus donec volutpat enim amet." +
                "Lorem ipsum dolor sit amet consectetur. Sodales nibh quam pulvinar nunc augue .",
        imageUrl = ""
    ),
)