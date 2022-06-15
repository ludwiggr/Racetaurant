import { Rating, Typography } from '@mui/material';
import { Component } from 'react';
import ReviewModel from '../model/review';
import commonStyles from '../styles/common.module.css';

export class Review extends Component<{ review: ReviewModel }> {
    render() {
        return (
            <div>
                <div className={commonStyles["left-right"]}>
                    <Typography>{this.props.review.title}</Typography>
                    <Typography>{this.props.review.author}</Typography>
                </div>
                <Rating name="read-only" value={this.props.review.rating} readOnly />
                <Typography>{this.props.review.content}</Typography>
            </div>
        )
    }
}

export default Review;