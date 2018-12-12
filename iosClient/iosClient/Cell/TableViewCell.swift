//
//  TableViewCell.swift
//  iosClient
//
//  Created by usayuki on 2018/12/06.
//  Copyright © 2018 usayuki. All rights reserved.
//

import UIKit
import ShareCode

class TableViewCell: UITableViewCell {

    @IBOutlet private weak var thumbnailImageView: UIImageView!
    @IBOutlet private weak var repositoryNameLabel: UILabel!
    @IBOutlet private weak var userNameLabel: UILabel!
    @IBOutlet private weak var starCountLabel: UILabel!
    @IBOutlet private weak var forkCountLabel: UILabel!
    
    func configure(_ repository: Item) {
        self.thumbnailImageView.setImage(from: repository.owner.avatarUrl)
        self.repositoryNameLabel.text = repository.name
        self.userNameLabel.text = repository.owner.login
        self.starCountLabel.text = "\(repository.stargazersCount)"
        self.forkCountLabel.text = "\(repository.forksCount)"
    }
}
