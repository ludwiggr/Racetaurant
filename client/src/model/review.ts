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

export const isReview = (review: any): review is Review => {
    return (typeof review === "object") && //
        (typeof review.title === "string") && //
        (typeof review.content === "string") && //
        (typeof review.author === "string") && //
        (typeof review.rating === "number");
}

export const isReviewArray = (reviews: any): reviews is Array<Review> => {
    return (Array.isArray(reviews)) && ((reviews).every(isReview));
}

export default Review;