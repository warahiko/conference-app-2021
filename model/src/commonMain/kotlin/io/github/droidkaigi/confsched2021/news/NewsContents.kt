package io.github.droidkaigi.confsched2021.news

import kotlinx.datetime.Instant
import kotlin.reflect.KClass

data class NewsContents(
    val newsContents: List<News> = listOf(),
    val favorites: Set<String> = setOf(),
) {
    val contents by lazy {
        newsContents.map {
            it to favorites.contains(it.id)
        }
    }

    fun filtered(filters: Filters): NewsContents {
        var news = newsContents.toList()
        if (filters.filterFavorite) {
            news = news.filter { news ->
                favorites.contains(news.id)
            }
        }
        return copy(newsContents = news)
    }

    fun filterNewsType(newsClass: KClass<out News>): NewsContents {
        return copy(newsContents = newsContents.filter { it::class == newsClass })
    }

    val size get() = newsContents.size
}

fun NewsContents?.orEmptyContents(): NewsContents = this ?: NewsContents()
fun LoadState<NewsContents>.getContents() = getValueOrNull() ?: NewsContents()

fun fakeNewsContents(): NewsContents {
    return NewsContents(
        // Generated by GenerateFakeContents.kt
        newsContents = listOf(
            News.Blog(
                id = "ee03fa43-a17e-4fa3-812e-a6fed30e3822",
                publishedAt = Instant.fromEpochMilliseconds(
                    1583544379858
                ),
                image = Image(
                    smallUrl = "https://miro.medium.com/max/320/1*-VG74mo_-SS3GLSteVuQEA.jpeg",
                    standardUrl = "https://miro.medium.com/max/480/1*-VG74mo_-SS3GLSteVuQEA.jpeg",
                    largeUrl = "https://miro.medium.com/max/640/1*-VG74mo_-SS3GLSteVuQEA.jpeg"
                ),
                media = Media.Medium,
                title = "DroidKaigi 2020でのCodelabsについて",
                summary = "DroidKaigiスタッフの@tomoya0x00です。DroidKaigi 2020の開催日が近づいてきましたね。この記事では、DroidKaigi 2020 Day.1に実施する DroidKaigiオリジナルCodelabsについてご紹介します。",
                link = "https://medium.com/droidkaigi/droidkaigi-2020%E3%81%A7%E3%81%AEcodelabs%E3%81%AB%E3%81%A4%E3%81%84%E3%81%A6-4a677d7456c6",
                language = "japanese",
                author = Author(
                    name = "Tomoya Miwa",
                    link = "https://medium.com/@tomoya0x00"
                )
            ),
            News.Blog(
                id = "7c0b46a9-3752-4050-8291-4f09b5aadb71",
                publishedAt = Instant.fromEpochMilliseconds(
                    1583676308319
                ),
                image = Image(
                    smallUrl = "https://miro.medium.com/max/320/1*-VG74mo_-SS3GLSteVuQEA.jpeg",
                    standardUrl = "https://miro.medium.com/max/480/1*-VG74mo_-SS3GLSteVuQEA.jpeg",
                    largeUrl = "https://miro.medium.com/max/640/1*-VG74mo_-SS3GLSteVuQEA.jpeg"
                ),
                media = Media.Medium,
                title = "DroidKaigi 2020 Codelabs",
                summary = "This is tomoya0x00 from DroidKaigi Committee. DroidKaigi 2020 is approaching!This post is about our original codelab that you can try on…",
                link = "https://medium.com/droidkaigi/droidkaigi-2020-codelabs-d190fa57ed10",
                language = "japanese",
                author = Author(
                    name = "Tomoya Miwa",
                    link = "https://medium.com/@tomoya0x00"
                )
            ),
            News.Video(
                id = "6cc7dacd-643e-4553-b155-78c59ffbf6f7",
                publishedAt = Instant.fromEpochMilliseconds(1593831600000),
                image = Image(
                    smallUrl = "https://droidkaigi.jp/fm/images/artwork.jpg",
                    standardUrl = "https://droidkaigi.jp/fm/images/artwork.jpg",
                    largeUrl = "https://droidkaigi.jp/fm/images/artwork.jpg"
                ),
                media = Media.DroidKaigiFM,
                title = "1. Android Studio 4.xとAndroid 11",
                summary = "1. Android Studio 4.xとAndroid 11",
                link = "https://droidkaigi.jp/fm/episode/1"
            ),
            News.Blog(
                id = "48b631b1-b565-44c6-9f94-256f025c8e29",
                publishedAt = Instant.fromEpochMilliseconds(
                    1594087371822
                ),
                image = Image(
                    smallUrl = "https://miro.medium.com/max/320/0*wT9LBn4T-JSLXhFY",
                    standardUrl = "https://miro.medium.com/max/480/0*wT9LBn4T-JSLXhFY",
                    largeUrl = "https://miro.medium.com/max/640/0*wT9LBn4T-JSLXhFY"
                ),
                media = Media.Medium,
                title = "DroidKaigiでデザイナーを募集します",
                summary = "こんにちは、DroidKaigi デザイナーの@mutoatuです。今回はDroidKaigiのデザイナーを募集しますので、その詳細をお知らせします。",
                link = "https://medium.com/droidkaigi/droidkaigi%E3%81%A7%E3%83%87%E3%82%B6%E3%82%A4%E3%83%8A%E3%83%BC%E3%82%92%E5%8B%9F%E9%9B%86%E3%81%97%E3%81%BE%E3%81%99-f4b59715b96c",
                language = "japanese",
                author = Author(
                    name = "Atsushi Muto",
                    link = "https://medium.com/@mutoatu"
                )
            ),
            News.Video(
                id = "60f2e2da-8628-4d40-8eda-3ba15394af1c",
                publishedAt = Instant.fromEpochMilliseconds(1594220400000),
                image = Image(
                    smallUrl = "https://droidkaigi.jp/fm/images/artwork.jpg",
                    standardUrl = "https://droidkaigi.jp/fm/images/artwork.jpg",
                    largeUrl = "https://droidkaigi.jp/fm/images/artwork.jpg"
                ),
                media = Media.DroidKaigiFM,
                title = "2. Android 11 Talks",
                summary = "2. Android 11 Talks",
                link = "https://droidkaigi.jp/fm/episode/2"
            ),
            News.Blog(
                id = "106ab422-b8e9-415c-8814-8fa9d29938d7",
                publishedAt = Instant.fromEpochMilliseconds(
                    1596092615466
                ),
                image = Image(
                    smallUrl = "https://miro.medium.com/max/320/1*c-gCfGSsYkCJiCMssCFL_Q.png",
                    standardUrl = "https://miro.medium.com/max/480/1*c-gCfGSsYkCJiCMssCFL_Q.png",
                    largeUrl = "https://miro.medium.com/max/640/1*c-gCfGSsYkCJiCMssCFL_Q.png"
                ),
                media = Media.Medium,
                title = "DroidKaigi 2020 活動報告",
                summary = "DroidKaigi 代表理事 mhidaka です。",
                link = "https://medium.com/droidkaigi/droidkaigi-2020-report-940391367b4e",
                language = "japanese",
                author = Author(
                    name = "mhidaka",
                    link = "https://medium.com/@mhidaka"
                )
            ),
            News.Blog(
                id = "f6691d69-ffbb-499e-812b-12878179fe25",
                publishedAt = Instant.fromEpochMilliseconds(
                    1596101666223
                ),
                image = Image(
                    smallUrl = "https://miro.medium.com/max/320/1*c-gCfGSsYkCJiCMssCFL_Q.png",
                    standardUrl = "https://miro.medium.com/max/480/1*c-gCfGSsYkCJiCMssCFL_Q.png",
                    largeUrl = "https://miro.medium.com/max/640/1*c-gCfGSsYkCJiCMssCFL_Q.png"
                ),
                media = Media.Medium,
                title = "DroidKaigi 2020 Activity Report",
                summary = "This activity report consolidates the effects of the cancellation of DroidKaigi 2020 that was to be held in February 2020, due to COVID-19.",
                link = "https://medium.com/droidkaigi/droidkaigi-2020-activity-report-en-cb93eea3083e",
                language = "japanese",
                author = Author(
                    name = "mhidaka",
                    link = "https://medium.com/@mhidaka"
                )
            ),
            News.Video(
                id = "02ff1334-19cf-4617-8834-12a59f1cf36b",
                publishedAt = Instant.fromEpochMilliseconds(1597892400000),
                image = Image(
                    smallUrl = "https://droidkaigi.jp/fm/images/artwork.jpg",
                    standardUrl = "https://droidkaigi.jp/fm/images/artwork.jpg",
                    largeUrl = "https://droidkaigi.jp/fm/images/artwork.jpg"
                ),
                media = Media.DroidKaigiFM,
                title = "3. DroidKaigi 2020 LiteとDroidKaigi 2020",
                summary = "3. DroidKaigi 2020 LiteとDroidKaigi 2020",
                link = "https://droidkaigi.jp/fm/episode/3"
            ),
            News.Podcast(
                id = "8f38a6f5-41fa-4faf-8d03-40f7c34fa8f1",
                publishedAt = Instant.fromEpochMilliseconds(1598590811000),
                image = Image(
                    smallUrl = "https://i.ytimg.com/vi/G5x1WUMj1gE/mqdefault.jpg",
                    standardUrl = "https://i.ytimg.com/vi/G5x1WUMj1gE/hqdefault.jpg",
                    largeUrl = "https://i.ytimg.com/vi/G5x1WUMj1gE/sddefault.jpg"
                ),
                media = Media.YouTube,
                title = "DroidKaigi 2020 Lite - KotlinのDelegated Propertiesを活用してAndroidアプリ開発をもっと便利にする / chibatching [JA]",
                summary = """本動画は2020/05/04に公開した動画を DroidKaigi 2020 Lite 用に編集し再公開したものです。

質問は https://forms.gle/nnwMqGWtH66SNkbM7 にお願いします。 19 時から Ask the Speaker ライブ配信を行います。

Day 2の再生リストはこちら: https://www.youtu""",
                link = "https://youtube.com/watch?v=G5x1WUMj1gE"
            ),
            News.Podcast(
                id = "21a03088-1ce5-4096-a915-cbf45e58e484",
                publishedAt = Instant.fromEpochMilliseconds(1598613661000),
                image = Image(
                    smallUrl = "https://i.ytimg.com/vi/uQrzy2d7y7s/mqdefault.jpg",
                    standardUrl = "https://i.ytimg.com/vi/uQrzy2d7y7s/hqdefault.jpg",
                    largeUrl = "https://i.ytimg.com/vi/uQrzy2d7y7s/sddefault.jpg"
                ),
                media = Media.YouTube,
                title = "DroidKaigi 2020 Lite - Day 2 Night Session",
                summary = """DroidKaigi 2020 Liteは3日間のオンラインチャリティイベントです。8月27日（木）～8月29日（土）の間に、オンラインセッション、Fireside chat、Ask the Speakerなどさまざまな技術トピックをお届け予定です。

Day 2のプレイリストはこちらです: https://www.youtube.com/playlist?""",
                link = "https://youtube.com/watch?v=uQrzy2d7y7s"
            ),
            News.Podcast(
                id = "9e223801-a73e-4710-bcce-35cc48d1d75b",
                publishedAt = Instant.fromEpochMilliseconds(1604548808000),
                image = Image(
                    smallUrl = "https://i.ytimg.com/vi/UCuf1vXPH3A/mqdefault.jpg",
                    standardUrl = "https://i.ytimg.com/vi/UCuf1vXPH3A/hqdefault.jpg",
                    largeUrl = "https://i.ytimg.com/vi/UCuf1vXPH3A/sddefault.jpg"
                ),
                media = Media.YouTube,
                title = "DroidKaigi 2020 - FlutterをRenderObjectまで理解する / kiri [JA]",
                summary = """FlutterはWidgetをツリー構造に組み合わせて、UIレイアウトを構築します。
それでは、構築されたWidgetツリーはどのようにスクリーンにレンダリングされるのでしょうか。
重要な概念はElementとRenderObjectです。
RenderObjectはレンダリングの責務を担い、ElementはWidgetとRenderObjectの仲介役の責""",
                link = "https://youtube.com/watch?v=UCuf1vXPH3A"
            ),
            News.Podcast(
                id = "8bf7bd0a-2ec8-45da-b6fa-406c1e5a0b36",
                publishedAt = Instant.fromEpochMilliseconds(1605585609000),
                image = Image(
                    smallUrl = "https://i.ytimg.com/vi/bsWHgePdLBg/mqdefault.jpg",
                    standardUrl = "https://i.ytimg.com/vi/bsWHgePdLBg/hqdefault.jpg",
                    largeUrl = "https://i.ytimg.com/vi/bsWHgePdLBg/sddefault.jpg"
                ),
                media = Media.YouTube,
                title = "DroidKaigi 2020 - Meta-Programming with Kotlin / Jitin Sharma [EN]",
                summary = """Kotlin has become go-to language for Android developers all over the world and the language itself has a large number of feature sets.
With greater acceptance of language, we look""",
                link = "https://youtube.com/watch?v=bsWHgePdLBg"
            ),
            News.Video(
                id = "b7718b84-1191-440b-bf7f-b8e079ba93e0",
                publishedAt = Instant.fromEpochMilliseconds(1605841200000),
                image = Image(
                    smallUrl = "https://droidkaigi.jp/fm/images/artwork.jpg",
                    standardUrl = "https://droidkaigi.jp/fm/images/artwork.jpg",
                    largeUrl = "https://droidkaigi.jp/fm/images/artwork.jpg"
                ),
                media = Media.DroidKaigiFM,
                title = "4. 大調達！検証端末ブラザーズ for 2020 秋冬",
                summary = "4. 大調達！検証端末ブラザーズ for 2020 秋冬",
                link = "https://droidkaigi.jp/fm/episode/4"
            ),
            News.Podcast(
                id = "925cd30a-63b6-4536-823b-bec1e46f9ddf",
                publishedAt = Instant.fromEpochMilliseconds(1606190409000),
                image = Image(
                    smallUrl = "https://i.ytimg.com/vi/GuwGFpQ5om0/mqdefault.jpg",
                    standardUrl = "https://i.ytimg.com/vi/GuwGFpQ5om0/hqdefault.jpg",
                    largeUrl = "https://i.ytimg.com/vi/GuwGFpQ5om0/sddefault.jpg"
                ),
                media = Media.YouTube,
                title = "DroidKaigi 2020 - Widget and Integration Testing in Flutter / JB Lorenzo [EN]",
                summary = "Automated Testing is essential to making your apps production-ready and to prevent introducing bugs when you change something. Flutter is an interesting case for testing because it",
                link = "https://youtube.com/watch?v=GuwGFpQ5om0"
            ),
            News.Video(
                id = "0b328510-182f-47f7-a2ae-a1afc6200baf",
                publishedAt = Instant.fromEpochMilliseconds(1608519600000),
                image = Image(
                    smallUrl = "https://droidkaigi.jp/fm/images/artwork.jpg",
                    standardUrl = "https://droidkaigi.jp/fm/images/artwork.jpg",
                    largeUrl = "https://droidkaigi.jp/fm/images/artwork.jpg"
                ),
                media = Media.DroidKaigiFM,
                title = "5. Notificiationよもやま話",
                summary = "5. Notificiationよもやま話",
                link = "https://droidkaigi.jp/fm/episode/5"
            )
        ),
        favorites = setOf()
    )
}
