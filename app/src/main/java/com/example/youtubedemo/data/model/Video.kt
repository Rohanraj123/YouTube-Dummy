        package com.example.youtubedemo.data.model

        import kotlinx.serialization.Serializable

        @Serializable
        data class Video(
            val id: Int,
            val thumbnail: ByteArray,
            val title: String,
            val likes: Int,
            val views: Int,
            val video: List<ByteArray>,
            val description: String,
            val comments: List<Comment>
        ) {
            override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as Video

                if (id != other.id) return false
                if (!thumbnail.contentEquals(other.thumbnail)) return false
                if (title != other.title) return false
                if (likes != other.likes) return false
                if (views != other.views) return false
                if (video != other.video) return false
                if (description != other.description) return false
                if (comments != other.comments) return false

                return true
            }

            override fun hashCode(): Int {
                var result = id
                result = 31 * result + thumbnail.contentHashCode()
                result = 31 * result + title.hashCode()
                result = 31 * result + likes
                result = 31 * result + views
                result = 31 * result + video.hashCode()
                result = 31 * result + description.hashCode()
                result = 31 * result + comments.hashCode()
                return result
            }
        }