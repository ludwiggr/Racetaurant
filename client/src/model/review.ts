/**
 * A Review of a restaurant
 */
class Review {
    title: string;
    content: string;
    author: string;
    rating: number;

    constructor(
        title: string,
        content: string,
        author: string,
        rating: number
    ) {
        this.title = title
        this.content = content
        this.author = author
        this.rating = rating
    }

}

/**
 * Checks if an objects is a {@link Review}
 * @param review the object to check
 * @returns `true` if the given value is a {@link Review}, `false` otherwise
 */
export const isReview = (review: any): review is Review => {
    return (typeof review === "object") && //
        (typeof review.title === "string") && //
        (typeof review.content === "string") && //
        (typeof review.author === "string") && //
        (typeof review.rating === "number");
}

/**
 * Checks if an objects is an array of {@link Review}s
 * @param reviews the object to check
 * @returns `true` if the given value is an array of {@link Review}s, `false` otherwise
 */
export const isReviewArray = (reviews: any): reviews is Array<Review> => {
    return (Array.isArray(reviews)) && ((reviews).every(isReview));
}

export default Review;