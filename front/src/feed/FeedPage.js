import React from "react";
import {
  View,
  Image,
  Text,
  FlatList, // here
} from "react-native";

export default class FeedPage extends React.Component {
  state = {
    data: [],
    page: 1, // here
  };

  _renderItem = ({ item }) => (
    <View style={{ borderBottomWidth: 1, marginTop: 20 }}>
      <Image source={{ uri: item.url }} style={{ height: 400 }} />
      <Text>{item.title}</Text>
      <Text>{item.id}</Text>
    </View>
  );

  // _getData 함수 수정
  _getData = () => {
    const url =
      "https://jsonplaceholder.typicode.com/photos?_limit=10&_page=" +
      this.state.page;
    fetch(url)
      .then((r) => r.json())
      .then((data) => {
        this.setState({
          data: this.state.data.concat(data),
          page: this.state.page + 1,
        });
      });
  };

  componentDidMount() {
    this._getData();
  }

  // here
  _handleLoadMore = () => {
    this._getData();
  };

  render() {
    return (
      <FlatList
        data={this.state.data}
        renderItem={this._renderItem}
        keyExtractor={(item, index) => item.id}
        onEndReached={this._handleLoadMore}
        onEndReachedThreshold={1}
      />
    );
  }
}
