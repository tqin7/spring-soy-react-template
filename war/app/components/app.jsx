import React from 'react';

export default class App extends React.Component {
  constructor(props) {
    super(props);
    console.log('App constructed');
    this.state = {
      counter: 0,
    };
    this.handleClick = this.handleClick.bind(this);
  }

  handleClick() {
    this.setState(prevState => ({ counter: prevState.counter + 1 }));
    // this.counter += 1;
  }

  render() {
    const { counter } = this.state;
    return (
      <button type="button" onClick={this.handleClick}>
        Click:
        { counter }
      </button>
    );
  }
}
