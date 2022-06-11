import React, { Component } from 'react'
import Times, { Time } from "../model/openingTimes";
import { Typography } from '@mui/material';
import styles from '../styles/openingTimes.module.css';


export class OpeningTimes extends Component<{ times: Times }> {
    render() {
        return (
            <div className={styles.container}>
                <Typography>Montag:</Typography>
                <OpeningTime time={this.props.times.monday} />
                <Typography>Dienstag: </Typography>
                <OpeningTime time={this.props.times.tuesday} />
                <Typography>Mittwoch:</Typography>
                <OpeningTime time={this.props.times.wednesday} />
                <Typography>Donnerstag:</Typography>
                <OpeningTime time={this.props.times.thursday} />
                <Typography>Freitag:</Typography>
                <OpeningTime time={this.props.times.friday} />
                <Typography>Samstag:</Typography>
                <OpeningTime time={this.props.times.saturday} />
                <Typography>Sonntag:</Typography>
                <OpeningTime time={this.props.times.sunday} />
            </div>
        )
    }
}

class OpeningTime extends Component<{ time: Time }> {
    render() {
        if (this.props.time === "closed") {
            return (
                <Typography>geschlossen</Typography>
            )
        }
        return (
            <Typography>{this.props.time.from} - {this.props.time.to}</Typography>
        )
    }
}

export default OpeningTimes