const path = require('path');

module.exports = {
  mode: 'development',
  entry: './app/index.jsx',
  output: {
    path: path.join(__dirname, './resources/scripts'),
    filename: 'bundle.js',
  },
  module: {
    rules: [
      {
        test: /\.(js|jsx)?$/,
        exclude: /node_modules/,
        use: 'babel-loader',
      },
      {
        test: /\.css$/,
        exclude: /node_modules/,
        use: 'style-loader!css-loader',
      },
    ],
  },
  resolve: {
    modules: ['node_modules', path.resolve('./app')],
    extensions: ['*', '.js', '.jsx'],
  },
  devServer: {
    contentBase: path.join(__dirname, './resources'),
  },
};
