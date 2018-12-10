//
//  TableViewCell.swift
//  iosClient
//
//  Created by usayuki on 2018/12/06.
//  Copyright © 2018 usayuki. All rights reserved.
//

import UIKit

class TableViewCell: UITableViewCell {

    @IBOutlet weak var thumbnailImageView: UIImageView!
    @IBOutlet weak var repositoryNameLabel: UILabel!
    @IBOutlet weak var userNameLabel: UILabel!
    @IBOutlet weak var starCountLabel: UILabel!
    @IBOutlet weak var forkCountLabel: UILabel!
    
    func configure() {
    }
}
